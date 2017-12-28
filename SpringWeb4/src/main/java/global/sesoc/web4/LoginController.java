package global.sesoc.web4;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	/* *
	 * 1. login - get	: login/loginForm.jsp로 이동
	 * 2. login - post	: session에 loginId를 담는다
	 * 3. logout - get	: session에 있는 loginId를 삭제
	 * */
	
	@RequestMapping (value="/login", method=RequestMethod.GET)
	public String loginPage() {
		return "login/loginForm";
	}
	
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String login(String id, String pw, HttpSession session) {
		
		if ("id".equals(id) && "pw".equals(pw)) {
			session.setAttribute("id", id);
			// 스프링은 사용자가 직접 jsp 페이지를 요청하지 않도록 만들었기 때문에
			// 모든 요청을 컨테이너를 통해 해야 한다.
			// 여기서 로그인이 되면 데이터를 작성해서 jsp 로 보내 값들을 출력해줄 필요가 없다
			// 그러니 그냥 redirect로 보낸다.(이 함수는 로그인 확인만 하면 제 할 일이 끝남)
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping (value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
