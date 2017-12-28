package global.sesoc.web7;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import global.sesoc.web7.dao.MemberMapper;
import global.sesoc.web7.vo.Member;

@Controller
@SessionAttributes({"userId"})
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// root-context안에 sqlsession bean이 있었다
	// 그 bean을 자동으로 연결
	@Autowired
	SqlSession sqlSession;  
	
	@RequestMapping (value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping (value = "/join", method = RequestMethod.POST)
	public String join(Member member) {
		logger.info("멤버 객체: {}", member);
		
		// debug는 일괄적으로 출력을 안 하게 만들 수도 있다 by log4j.xml
		// logger.debug("멤버: {}", member);
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		Member existedMem = null;
		try {
			existedMem = mapper.selectOne(member.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (existedMem != null) {
			return "redirect:/join";
		}
		
		int result = 0;
		try {
			result = mapper.insert(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (result == 0) {
			return "redirect:/join";
		} else {
			return "redirect:/";
		}
		
	}
	
	@RequestMapping (value = "/info", method = RequestMethod.GET)
	public String info(
			@ModelAttribute("userId") String id, 
			Model model) {
		logger.info("검색할 아이디: {}", id);
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		Member member = null;
		
		try {
			member = mapper.selectOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("member", member);
		
		return "info";
	}
	
	@RequestMapping (value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("모든 회원 정보 취득 {} {}", "x", "y");
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		ArrayList<Member> list = new ArrayList<>();
		try {
			list = mapper.selectList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping (value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		logger.info("삭제하려는 회원 아이디: {}", id);
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			mapper.deleteOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/list";
	}
	
	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public String login(String id, String password, Model model) {
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		Member member = null;
		try {
			member = mapper.selectOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (member == null) {
			model.addAttribute("error", "존재하지 않는 ID");
			return "loginForm";
		}
		
		if (!member.getPassword().equals(password)) {
			model.addAttribute("error", "비밀번호 오류");
			return "loginForm";
		}
		
		
		//session.setAttribute("userId", member.getId());
		model.addAttribute("userId", member.getId());
		
		return "redirect:/";
	}
	
	@RequestMapping (value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status, HttpSession session) {
		status.setComplete();
		
		//session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping (value = "/idCheck", method = RequestMethod.GET)
	public String idDoubleCheckForm() {
		return "idCheck";
	}
	
	@RequestMapping (value = "/idCheck", method = RequestMethod.POST)
	public String idDoubleCheck(String id, Model model) {
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		Member member = null;
		try {
			member = mapper.selectOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (member == null) {
			logger.info("사용 가능");
			model.addAttribute("checked", "checked");
		} else {
			logger.info("사용 불가");
			model.addAttribute("checked", "checked");
			model.addAttribute("duplicated", "dup");
		}
		
		return "idCheck";
	}
	
	@RequestMapping (value = "/update", method = RequestMethod.GET)
	public String update(
			@ModelAttribute("userId") String id,
			Model model) {
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		Member member = null;
		try {
			member = mapper.selectOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* 로그인 사용자의 정보 보내주기 */
		model.addAttribute("member", member);
		/* 수정 모드에 들어갔음을 알려주기 */
		model.addAttribute("updateMode", true);
		
		return "info";
	}
	
	@RequestMapping (value = "/update", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("userId") String id,
			Member member, 
			String password_c) {
		
		
		if (!member.getPassword().equals(password_c)) {
			logger.info("password != password_c");
			return "redirect:/info";
		}
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		member.setId(id);
		logger.info("member to update {}", member);
		try {
			mapper.update(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/info";
	}
}


























