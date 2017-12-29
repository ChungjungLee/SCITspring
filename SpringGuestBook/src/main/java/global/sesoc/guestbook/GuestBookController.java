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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/* 방명록 글들 가져와서 보여주기 */
	@RequestMapping (value = "/guestbook", method = RequestMethod.GET)
	public String guestbook(Model model) {
		logger.info("");
		
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
	public String guestbookWrite(GuestBook guestbook) {
		GuestBookMapper mapper = sqlSession.getMapper(GuestBookMapper.class);
		
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
	}
	
	
	/* 방명록 글 삭제하기 */
	@RequestMapping (value = "/guestbookdelete", method = RequestMethod.POST)
	public String guestbookDelete(String password, String clickednum) {
		//logger.info("pw: {}, num: {}", password, clickednum);
		System.out.println("delete delete " + password + ", " + clickednum);
		return "redirect:/guestbook";
	}
	
	/* 방명록 글 수정하기 */
	@RequestMapping (value = "/guestbookupdate", method = RequestMethod.POST)
	public String guestbookUpdate(String password, String clickednum) {
		//logger.info("pw: {}, num: {}", password, clickednum);
		System.out.println("update update " + password +", " + clickednum);
		return "redirect:/guestbook";
	}
}



























