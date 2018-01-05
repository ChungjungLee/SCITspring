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

import global.sesoc.web8.dao.BoardDAO;
import global.sesoc.web8.vo.Board;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	BoardDAO boardDAO;
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * 글 목록 출력하는 페이지로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		ArrayList<Board> result = boardDAO.readAll();
		int numOfList = result.size();
		
		model.addAttribute("list", result);
		model.addAttribute("numOfList", numOfList);
		
		return "boardPage/list";
	}
	
	/**
	 * 글쓰기 폼으로 이동
	 * @return
	 */
	@RequestMapping (value = "write", method = RequestMethod.GET)
	public String writeForm() {
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
			return "redirect:list";
		} else {
			// 글쓰기 실패
			logger.info("글쓰기 실패");
			return "redirect:list";
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
		
		logger.info("boardnum: {}", boardnum);
		
		// 1. 글 번호로 DAO를 통해 글 하나를 읽어 온다
		Board board = boardDAO.readOne(boardnum);
		
		if (board == null) {
			// 2. 값이 없다면 게시판 목록으로 리다이렉트
			return "redirect:list";
		} else {
			// 3. 조회수를 올려준다(올려준 다음에 읽어 오든지, 읽은 다음에 조회수를 증가시켜 보내든지)
			if (boardDAO.updateHits(boardnum) == 1) {
				// 4-1. 제대로 조회수 증가가 이루어지면 model에 넣어서 해당 view로 넘겨준다
				board.setHits(board.getHits() + 1);
				model.addAttribute("board", board);
				
				return "boardPage/readForm";
			} else {
				//  4-2.
				return "redirect:list";
			}
			
		}
		
	}
}























