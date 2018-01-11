package global.sesoc.web8.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web8.dao.ReplyDAO;
import global.sesoc.web8.vo.Reply;

@Controller
@RequestMapping("reply")
public class ReplyController {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	/**
	 * 리플 작성하기
	 * @param reply
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "writeReply", method = RequestMethod.POST)
	public String write(Reply reply, HttpSession session, Model model) {
		
		String loginid = (String) session.getAttribute("loginid");
		reply.setId(loginid);
		
		int result = replyDAO.write(reply);
		
		if (result == 1) {
			model.addAttribute("boardnum", reply.getBoardnum());
			return "redirect:../board/read";
		} else {
			model.addAttribute("boardnum", reply.getBoardnum());
			return "redirect:../board/read";
		}
		
	}
	
	/**
	 * 리플 수정하기
	 * @param reply
	 * @return
	 */
	@RequestMapping (value = "updateReply", method = RequestMethod.POST)
	public String update(HttpSession session, String text, Integer replynum) {
		
		// 지우고자 하는 리플의 작성자가 현재 로그인 한 작성자인지 판별
		String loginid = (String) session.getAttribute("loginid");
		Reply reply = replyDAO.readOne(replynum);
		
		if (reply == null || !reply.getId().equals(loginid)) {
			return "error";
		} 
		
		reply.setText(text);
		
		int result = replyDAO.update(reply);
		
		if (result == 1) {
			return "redirect:../board/read?boardnum=" + reply.getBoardnum();
		} else {
			logger.info("리플 수정 중 오류 발생");
			return "redirect:../board/read?boardnum=" + reply.getBoardnum();
		}
		
	}
	
	/**
	 * 해당 리플 삭제하기
	 * @param replynum
	 * @param boardnum
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "deleteReply", method = RequestMethod.GET)
	public String delete(Integer replynum, Integer boardnum, HttpSession session) {
		logger.info("delete replynum:{}, boardnum:{}", replynum, boardnum);
		
		String loginid = (String) session.getAttribute("loginid");
		
		Reply reply = replyDAO.readOne(replynum);
		
		if (reply == null || !reply.getId().equals(loginid)) {
			return "error";
		}
		
		int result = replyDAO.delete(replynum);
		
		if (result == 1) {
			return "redirect:../board/read?boardnum=" + boardnum;
		} else {
			logger.info("리플 삭제 중 오류 발생");
			return "redirect:../board/read?boardnum=" + boardnum;
		}
		
	}
}



























