package global.sesoc.web8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web8.dao.ReplyDAO;
import global.sesoc.web8.vo.Reply;

@Controller
@RequestMapping("reply")
public class ReplyController {
	
	@Autowired
	ReplyDAO replyDAO;
	
	@RequestMapping (value = "", method = RequestMethod.POST)
	public String write(Reply reply, HttpSession session) {
		
		String loginid = (String) session.getAttribute("loginid");
		
		return "";
	}
}
