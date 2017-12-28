package global.sesoc.web4;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
	
	/*
	 * mapping
	 * value : sessionTest
	 * method : get
	 */
	@RequestMapping (value="/sessionTest", method=RequestMethod.GET)
	public String sessionTest() {
		return "session/sessionTest";
	}
	
	/* session을 이용하려면 HttpSession 클래스를 이용해야 한다 */
	@RequestMapping (value="/sessionSave", method=RequestMethod.GET)
	public String sessionSave(HttpSession session) {
		/* model에 값을 저장하고 redirect하면 모든 데이터가 사라졌지만 세션은 그러지 않다 */
		session.setAttribute("num", 100);
		session.setAttribute("str", "졸려");
		
		// redirect:[url(주소)] 여기서는 절대 주소를 사용했다
		return "redirect:/sessionTest";
	}
	
	@RequestMapping (value="/sessionDelete", method=RequestMethod.GET)
	public String sessionDelete(HttpSession session) {
		
		/* 데이터를 하나씩 지우는 방법 */
		session.removeAttribute("num");
		session.removeAttribute("str");
		
		/* 세션에 저장된 데이터를 모두 지우는 방법 */
		session.invalidate();
		
		// 아래와 같은 것도 있다고 한다
		// return "forward:/sessionTest";
		return "redirect:/sessionTest";
	}
}





























