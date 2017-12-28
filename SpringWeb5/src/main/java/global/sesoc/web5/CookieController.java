package global.sesoc.web5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CookieController {
	
	@RequestMapping (value = "/cookie1", method = RequestMethod.GET)
	public String cookie1(HttpServletResponse res) {
		/*
		 * session은 object로 저장이 가능했다 왜?
		 * session도 결국에는 자바로 구성되어 있기 때문
		 */
		
		/*
		 * user한테 저장할 쿠키 정보를 저장해야 한다
		 * 쿠키는 사용자의 컴퓨터에 저장되는 정보라 객체 형태로 저장할 수 없다
		 * 문자열의 형태로 저장할 수 밖에 없다
		 * new Cookie(String key, String value);
		 */
		Cookie c1 = new Cookie("str", "remember, no korean");
		Cookie c2 = new Cookie("num", "100");
		
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "redirect:/";
	}
	
	@RequestMapping (value = "/cookie2", method = RequestMethod.GET)
	public String cookie2(HttpServletRequest req) {
		/*
		 * 쿠키 정보를 얻어 온다
		 * 쿠키는 여러 정보가 있기 때문에 항상 Cookie의 배열로 받아야 한다
		 */
		Cookie[] cookies = req.getCookies();
		
		if (cookies == null) {
			return "redirect:/";
		}
		
		for (Cookie c : cookies) {
			System.out.println(c.getName() + ", " + c.getValue());
		}
		
		return "redirect:/";
	}
	
	@RequestMapping (value = "/cookie3", method = RequestMethod.GET)
	public String cookie3(HttpServletRequest req, HttpServletResponse res) {
		/*
		 * 사실 쿠키를 삭제하는 것은 없다고 보면 된다
		 * 다만 쿠키 내 속성의 유효기간은 존재한다
		 * 그러므로 유효기간은 0으로 세팅하고 다시 전송하면 삭제와 비슷한 개념이 되겠다
		 */
		Cookie[] cookies = req.getCookies();
		
		for (Cookie c : cookies) {
			c.setMaxAge(0);
			res.addCookie(c);
		}
		
		/*
		Cookie c1 = new Cookie("str", "");
		Cookie c2 = new Cookie("num", "");
		c1.setMaxAge(0);	// 초 단위
		c2.setMaxAge(0);
		
		res.addCookie(c1);
		res.addCookie(c2);
		*/
		
		return "redirect:/";
	}
	
	// Cookie를 가져오는 간편한 방법: annotation을 이용
	@RequestMapping (value = "/cookie4", method = RequestMethod.GET)
	public String cookie4(
			@CookieValue(name = "str", defaultValue = "none") String str,
			@CookieValue(name = "num", defaultValue = "0") String num
			) {
		
		System.out.println("str = " + str);
		System.out.println("num = " + num);
		
		return "redirect:/";
	}
	
	
}
























