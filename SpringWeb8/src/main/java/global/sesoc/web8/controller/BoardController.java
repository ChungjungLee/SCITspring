package global.sesoc.web8.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import global.sesoc.web8.dao.BoardDAO;
import global.sesoc.web8.dao.ReplyDAO;
import global.sesoc.web8.util.PageNavigator;
import global.sesoc.web8.vo.Board;
import global.sesoc.web8.vo.Reply;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	BoardDAO boardDAO;
	@Autowired
	ReplyDAO replyDAO;
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
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
		int totalCount = boardDAO.selectTotalCount(text);
		
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
	public String write(Board board, HttpSession session) {
		// 1. 세션에서 로그인된 아이디 취득(interceptor걸면 예외처리 필요 x)
		String loginid = (String) session.getAttribute("loginid");
		
		// 2. board에 아이디 설정
		board.setId(loginid);
		
		// 3. DAO 통해서 데이터 저장
		int result = boardDAO.write(board);
		
		if (result == 1) {
			// 글쓰기 성공
			return "redirect:list?pagenum=1";
		} else {
			// 글쓰기 실패
			logger.info("글쓰기 실패");
			return "redirect:list?pagenum=1";
		}
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
		
		// 글에 딸린 리플 읽어오기
		ArrayList<Reply> replyList = replyDAO.readAll(boardnum);
		
		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);
		
		return "boardPage/readForm";
		
	}
	
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
		
		model.addAttribute("action", "update");
		model.addAttribute("board", board);
		return "boardPage/write";
	}
	
	/**
	 * 게시글 수정 실제 로직, 
	 * @param boardnum
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.POST)
	public String update(Board board, HttpSession session) {
		
		String loginid = (String) session.getAttribute("loginid");
		board.setId(loginid);
		
		int result = boardDAO.update(board);
		
		if (result == 1) {
			return "redirect:read?boardnum=" + board.getBoardnum();
		} else {
			return "redirect:list?pagenum=1";
		}
		
	}
	
	/**
	 * 게시글을 삭제한다
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
		
		int result = boardDAO.delete(boardnum);
		
		if (result == 1) {
			return "redirect:read?boardnum=" + boardnum;
		} else {
			logger.info("게시글 삭제 중 오류 발생");
			return "redirect:read?boardnum=" + boardnum;
		}
		
	}
}























