package global.sesoc.web8.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.web8.dao.AttachmentDAO;
import global.sesoc.web8.dao.BoardDAO;
import global.sesoc.web8.dao.ReplyDAO;
import global.sesoc.web8.service.BoardService;
import global.sesoc.web8.util.FileService;
import global.sesoc.web8.util.PageNavigator;
import global.sesoc.web8.vo.Attachment;
import global.sesoc.web8.vo.Board;
import global.sesoc.web8.vo.Reply;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private ReplyDAO replyDAO;
	@Autowired
	private AttachmentDAO attachmentDAO;
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// /는 root를 가리키는데 윈도에서는 C:\boardfile에 저장 된다
	private final String UPLOAD_PATH = "/boardfile";
	
	private final int LIMIT = 10;	// 페이지 당 보여줄 게시글 수
	private final int PAGES = 5;	// 그룹 당 보여줄 페이지 수
	
	/**
	 * 글 목록 출력하는 페이지로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "list", method = RequestMethod.GET)
	public String list(
			Model model, 
			@RequestParam(value="pagenum", defaultValue="1") int currentPage, 
			@RequestParam(value="searchOption", defaultValue="") String select,
			@RequestParam(value="searchText", defaultValue="") String text) {
		/*
		 * @RequestParam() annotation
		 * value의 값에 맞는 사용자의 argument를 받아와서 해당 변수에 넣겠다
		 * argument에서 찾지 못하면 defaultValue의 값을 넣는다
		 */
		
		// 검색어를 가지고 해당 하는 게시글을 전부 읽어온다
		// LIMIT 몇 개 만큼 가져올 것인지
		// page(OFFSET) 어디서부터 가져올 것인지
		ArrayList<Board> searchResult = boardDAO.search(LIMIT, currentPage, select, text);
		
		// 검색된 결과의 게시글 총 수
		int totalCount = boardDAO.selectTotalCount(select, text);
		
		// 네비게이터 표시를 위한 객체 생성
		PageNavigator navi = new PageNavigator(LIMIT, PAGES, currentPage, totalCount);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("searchList", searchResult);
		model.addAttribute("navi", navi);
		
		return "boardPage/list";
	}
	
	/**
	 * 글쓰기 폼으로 이동
	 * @return
	 */
	@RequestMapping (value = "write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("action", "write");
		return "boardPage/write";
	}
	
	/**
	 * 글쓰기 실제 로직, 데이터베이스에 글 저장
	 * @param board
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "write", method = RequestMethod.POST)
	public String write(Board board, MultipartFile[] uploads, HttpSession session) {
		/*
		 * 파일을 제외한 순수 글 처리를 먼저 해줘야 foreign key를 사용하는 첨부파일을 등록할 수 있다
		 */
		// 1. 세션에서 로그인된 아이디 취득(interceptor걸면 예외처리 필요 x)
		String loginid = (String) session.getAttribute("loginid");
		board.setId(loginid);
		
		HashMap<String, Object> resultMap = boardDAO.write(board);
		int result = (Integer) resultMap.get("result");
		
		if (result != 1) {
			logger.debug("글쓰기 실패");
			return "redirect:list?pagenum=1";
		}
		
		/*
		 * 첨부파일 처리
		 */
		if (uploads != null && uploads.length != 0) {
			for (MultipartFile upload : uploads) {
				// storage에 file 저장
				String savedFile = FileService.saveFile(upload, UPLOAD_PATH);
				
				Attachment attachment = new Attachment();
				attachment.setBoardnum((Integer) resultMap.get("boardnum"));
				attachment.setOriginalfile(upload.getOriginalFilename());
				attachment.setSavedfile(savedFile);
				
				// DB에 첨부파일 저장
				int resultFile = attachmentDAO.write(attachment);
				if (resultFile == 1) {
					logger.debug("첨부파일 업로드 완료");
				} else {
					if (FileService.deleteFile(UPLOAD_PATH + "/" + savedFile)) {
						logger.debug("파일 업로드 실패로 저장된 파일 삭제 성공");
					} else {
						logger.debug("파일 업로드 실패로 저장된 파일 삭제 실패");
					}
				}
			}
		}
		
		return "redirect:list?pagenum=1";
	}
	
	/**
	 * 글 하나 읽기
	 * @param boardnum
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "read", method = RequestMethod.GET)
	public String read(Integer boardnum, Model model) {
		// 글 번호로 DAO를 통해 글 하나를 읽어 온다
		Board board = boardDAO.readOne(boardnum);
		
		if (board == null) {
			return "redirect:list?pagenum=1";
		}
		
		// 조회수를 올려준다(올려준 다음에 읽어 오든지, 읽은 다음에 조회수를 증가시켜 보내든지)
		if (boardDAO.updateHits(boardnum) != 1) {
			return "redirect:list?pagenum=1";
		} 
			
		// 제대로 조회수 증가가 이루어지면 보낼 것도 조회수 증가
		board.setHits(board.getHits() + 1);
		
		// 글에 딸린 첨부파일 읽어오기
		ArrayList<Attachment> attachmentList = attachmentDAO.readAll(boardnum);
		
		// 글에 딸린 리플 읽어오기
		ArrayList<Reply> replyList = replyDAO.readAll(boardnum);
		
		model.addAttribute("board", board);
		model.addAttribute("attachmentList", attachmentList);
		model.addAttribute("attachmentListSize", attachmentList.size());
		model.addAttribute("replyList", replyList);
		
		return "boardPage/readForm";
		
	}
	
	// TODO: 첨부 파일 수정할 수 있도록 변경
	/**
	 * 게시글 수정 페이지로 이동
	 * @param boardnum
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.GET)
	public String updateForm(Integer boardnum, Model model, HttpSession session) {
		
		String loginid = (String) session.getAttribute("loginid");
		
		Board board = boardDAO.readOne(boardnum);
		
		if (board == null || !board.getId().equals(loginid)) {
			return "error";
		}
		
		ArrayList<Attachment> attachmentList = attachmentDAO.readAll(boardnum);
		
		model.addAttribute("action", "update");
		model.addAttribute("board", board);
		model.addAttribute("attachmentList", attachmentList);
		
		return "boardPage/write";
	}
	
	// TODO: 첨부 파일 수정할 수 있도록 변경
	/**
	 * 게시글 수정 실제 로직
	 * @param boardnum
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.POST)
	public String update(Board board, MultipartFile[] uploads, 
			Integer[] deletenums, Integer[] attachmentnums, HttpSession session) {
		
		for (Integer i : attachmentnums) {
			logger.info("첨부파일 번호: {}", i);
		}
		
		logger.info("수정시 첨부파일 개수: {}", uploads.length);
		for (MultipartFile upload : uploads) {
			logger.info("filename: {}", upload.getOriginalFilename());
		}
		
		
		/* 첨부파일 삭제 */
		if (deletenums != null) {
			for (Integer deletenum : deletenums) {
				Attachment toDelete = attachmentDAO.readOne(deletenum);
				FileService.deleteFile(UPLOAD_PATH + "/" + toDelete.getSavedfile());
				
				if (attachmentDAO.delete(deletenum) != 1) {
					logger.debug("첨부 파일 삭제 오류 발생");
					return "redirect:update?boardnum=" + board.getBoardnum();
				}
			}
		}
		
		/* 첨부파일 수정 */
		for (int i = 0; i < uploads.length; i++) {
			logger.info("수정하고자 하는 파일: {}", uploads[i].getOriginalFilename());
			if (uploads[i].getSize() == 0) continue;
			
			
			// 기존 첨부파일 삭제
			Attachment toEdit = attachmentDAO.readOne(attachmentnums[i]);
			FileService.deleteFile(UPLOAD_PATH + "/" + toEdit.getSavedfile());
			
			// 새로운 첨부파일 업로드
			String newSavedfile = FileService.saveFile(uploads[i], UPLOAD_PATH);
			
			// DB 수정
			toEdit.setOriginalfile(uploads[i].getOriginalFilename());
			toEdit.setSavedfile(newSavedfile);
			
			if (attachmentDAO.update(toEdit) != 1) {
				logger.debug("첨부 파일 수정 오류 발생");
				return "redirect:update?boardnum=" + board.getBoardnum();
			}
		}
		
		/* 글 수정 */
		String loginid = (String) session.getAttribute("loginid");
		board.setId(loginid);
		
		int result = boardDAO.update(board);
		
		if (result == 1) {
			return "redirect:read?boardnum=" + board.getBoardnum();
		} else {
			return "redirect:list?pagenum=1";
		}
		
	}
	
	// TODO: 게시글에 달려 있는 첨부파일 및 댓글을 지워줘야 하는지 확인 필요
	/**
	 * 게시글을 삭제한다, 달려 있는 첨부 파일은 스토리지에서 삭제
	 * @param boardnum
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "delete", method = RequestMethod.GET)
	public String delete(Integer boardnum, HttpSession session) {
		
		String loginid = (String) session.getAttribute("loginid");
		
		Board board = boardDAO.readOne(boardnum);
		
		if (board == null || !board.getId().equals(loginid)) {
			return "error";
		}
		
		/* storage에 저장된 파일 삭제 */
		ArrayList<Attachment> list = attachmentDAO.readAll(boardnum);
		for (Attachment attach : list) {
			FileService.deleteFile(UPLOAD_PATH + "/" + attach.getSavedfile());
		}
		
		/* 글 삭제 */
		int result = boardDAO.delete(boardnum);
		
		if (result == 1) {
			return "redirect:read?boardnum=" + boardnum;
		} else {
			logger.debug("게시글 삭제 중 오류 발생");
			return "redirect:read?boardnum=" + boardnum;
		}
	}
	
	/**
	 * 게시글에 달려 있는 첨부파일을 다운로드한다
	 * @param boardnum 게시글 번호
	 * @param attachmentnum 다운로드 하려는 첨부파일의 번호
	 * @param response 사용하는 이유: 파일을 읽어서 스트림으로 유저에게 보내기 위해 사용
	 * @return
	 */
	@RequestMapping (value = "download", method = RequestMethod.GET)
	public String download(Integer boardnum, Integer attachmentnum, HttpServletResponse response) {
		/*
		 * 다운로드하려는 첨부 파일의 번호를 알고 있으므로 DB로부터 읽어 온다
		 */
		Attachment attachment = attachmentDAO.readOne(attachmentnum);
		if (attachment == null) {
			return "error";
		}
		
		String originalFile = attachment.getOriginalfile();
		
		try {
			// http header 설정
			// filename을 한글로 보내기 위해서 utf 인코딩이 필요
			// 이 정보를 받은 클라이언트 브라우저는 앞으로 파일이 전송될 것을 예견하고 스트림을 열 준비를 한다
			// header를 건드렸기 때문에 일반적인 페이지 이동이 아니라 파일 이동으로 동작을 할 것이다
			response.setHeader(
					"Content-Disposition", 
					"attachment;filename=" + URLEncoder.encode(originalFile, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일이 저장된 storage의 전체 경로를 받아온다.
		String fullPath = UPLOAD_PATH + "/" + attachment.getSavedfile();
		
		// 스트림을 선언(파일을 저장된 장소, 서버로부터 읽어올 것이다)
		FileInputStream fis = null;
		
		// 스트림을 선언(읽어 들인 파일을 클라이언트에게 보내줄 것이다)
		ServletOutputStream sos = null;
		
		try {
			fis = new FileInputStream(fullPath);
			// sos는 이미 response에 만들어져 있는 내장 객체이므로 그걸 가져와 사용
			sos = response.getOutputStream();
			// 인풋에서 아웃풋으로 파일 복사
			FileCopyUtils.copy(fis, sos);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (sos != null)
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		// return이 없는 이유: 다운로드하고 이동할 필요가 없기 때문
		return null;
	}
	
	/*
	@RequestMapping ()
	public String edit(
			MultipartFile upload,
			Board board) {
		Board old = boardDAO.readOne(board.getBoardnum());
		
		if (upload.isEmpty() == false &&
				old.getOriginalfile() != null &&
				old.getSavedfile() != null) {
			// 이미 파일이 저장되어있다
			String s = UPLOAD_PATH + "/" + old.getSavedfile();
			FileService.deleteFile(s);
			
			String p = FileService.saveFile(upload, UPLOAD_PATH);
			board.setOriginalfile(upload.getOriginalFilename());
			board.setSavedfile(p);
		}
		return "";
	}
	*/
}























