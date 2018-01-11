package global.sesoc.web8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.sesoc.web8.dao.AttachmentDAO;
import global.sesoc.web8.dao.BoardDAO;
import global.sesoc.web8.dao.ReplyDAO;
import global.sesoc.web8.vo.Board;

@Service
public class BoardService {
	// db에 접근하는 건 서비스에게 전부 위임
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private ReplyDAO replyDAO;
	@Autowired
	private AttachmentDAO attachmentDAO;
	
	
	public Board readBoard(int boardnum) {
		// 글 번호로 DAO를 통해 글 하나를 읽어 온다
		Board board = boardDAO.readOne(boardnum);
		
		if (board == null) {
			return null;
		}
		
		// 조회수를 올려준다(올려준 다음에 읽어 오든지, 읽은 다음에 조회수를 증가시켜 보내든지)
		if (boardDAO.updateHits(boardnum) != 1) {
			return null;
		} 
				
		return board;
	}
}


















