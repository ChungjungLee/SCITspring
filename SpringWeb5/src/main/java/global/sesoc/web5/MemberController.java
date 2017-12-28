package global.sesoc.web5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpServletResponse res) {
		
		/*
		 * 로그인 정보를 세션에 저장하지 않고 쿠키를 통해 저장해 보겠다
		 * 실제로는 이렇게 사용하면 안 된다
		 */
		if ("abc123".equals(id) && "123".equals(pw)) {
			// 쿠키 하나를 생성 -> loginId
			Cookie c = new Cookie("loginId", id);
			res.addCookie(c);
			
			return "redirect:/";
		}
		
		return "redirect:/login";
	}
	
	@RequestMapping (value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletResponse res) {
		
		Cookie c = new Cookie("loginId", "");
		c.setMaxAge(0);
		
		res.addCookie(c);
		
		return "redirect:/";
	}
}























