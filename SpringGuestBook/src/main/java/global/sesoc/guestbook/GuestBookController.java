package global.sesoc.guestbook;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.guestbook.dao.GuestBookMapper;
import global.sesoc.guestbook.vo.GuestBook;

@Controller
public class GuestBookController {
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	/* 방명록 글들 가져와서 보여주기 */
	@RequestMapping (value = "/guestbook", method = RequestMethod.GET)
	public String guestbook(Model model) {
		GuestBookMapper mapper = sqlSession.getMapper(GuestBookMapper.class);
		
		ArrayList<GuestBook> list = null;
		try {
			list = mapper.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("list", list);
		
		return "guestbook";
	}
	
	/* 방명록 글 작성할 페이지로 이동하기 */
	@RequestMapping (value = "/guestbookwrite", method = RequestMethod.GET)
	public String guestbookForm() {
		return "guestbookForm";
	}
	
	/* 방명록 글 작성한 것 받아서 저장하기 */
	@RequestMapping (value = "/guestbookwrite", method = RequestMethod.POST)
	public String guestbookWrite(GuestBook guestbook, String action) {
		
		if (guestbook == null || action == null) {
			return "errorPage";
		}
		
		GuestBookMapper mapper = sqlSession.getMapper(GuestBookMapper.class);
		
		if ("write".equals(action)) {
			int result = 0;
			try {
				result = mapper.write(guestbook);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (result == 0) {
				return "redirect:/guestbookwirte";
			} else {
				return "redirect:/guestbook";
			}
			
		} else {
			int result = 0;
			try {
				result = mapper.update(guestbook);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (result == 0) {
				return "redirect:/guestbook";
			} else {
				return "redirect:/guestbook";
			}
		}
	}
	
	
	/* 방명록 글 삭제하기 */
	@RequestMapping (value = "/guestbookdelete", method = RequestMethod.POST)
	public String guestbookDelete(String password, String clickednum) {
		
		if (password == null || clickednum == null) {
			return "errorPage";
		}
		
		GuestBookMapper mapper = sqlSession.getMapper(GuestBookMapper.class);
		
		GuestBook guestbook = null;
		try {
			guestbook = mapper.readOne(Integer.parseInt(clickednum));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (guestbook == null || !guestbook.getPassword().equals(password)) {
			logger.info("PASSWORD WRONG!!!");
			return "redirect:/guestbook";
		}
		
		int result = 0;
		try {
			result = mapper.delete(Integer.parseInt(clickednum));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (result == 0) {
			logger.info("Error occurred while DELETING!!!");
			return "redirect:/guestbook";
		} else {
			return "redirect:/guestbook";
		}
		
	}
	
	/* 방명록 글 수정 요청 처리하기 */
	@RequestMapping (value = "/guestbookupdate", method = RequestMethod.POST)
	public String guestbookUpdate(String password, String clickednum, Model model) {
		
		if (password == null || clickednum == null) {
			return "errorPage";
		}
		
		GuestBookMapper mapper = sqlSession.getMapper(GuestBookMapper.class);
		
		GuestBook guestbook = null;
		try {
			guestbook = mapper.readOne(Integer.parseInt(clickednum));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (guestbook == null || !guestbook.getPassword().equals(password)) {
			return "redirect:/guestbook";
		} else {
			model.addAttribute("guestbook", guestbook);
			
			return "guestbookForm";
		}
		
	}
	
}



























