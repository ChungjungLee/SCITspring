package global.sesoc.web1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web1.vo.PersonVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	// requestmapping의 value 주소와 method 이름이 같을 필요는 없다
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1 (Model model) {
		
		// parameter에 request, response를 받질 않는데 어떻게 받아서 활용하는가?
		// 스프링이 알아서 받아온다 by model
		
		logger.info("test1 왔다 감");
		
		// request.addAttribute()와 같음
		model.addAttribute("str", "test1에서 넘겨줌");
		model.addAttribute("num", 100);
		
		// model이랑 parameter랑 다르다.
		// 그래서 test2에서 redirect 할 때 model에 넣었던 attribute는 ?뒤에 parameter로 넘어오기 때문에
		// 여기서 model을 통해서 받아올 수 없다.
		
		// 이렇게 주소를 쓰게 되면 forward를 시킨다는 것
		//return "test1";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2 (Model model) {
		model.addAttribute("str2", "test2에서 넘겨줌");
		model.addAttribute("num2", 200);
		
		// redirect하려면 redirect:를 주소 앞에 써주면 된다
		// redirect:[url]
		// view(jsp file)이 아니다
		// 스프링은 redirect할 때 model을 들고 가도록 만들어 놨다
		return "redirect:/test1";
	}
	
	/* GET으로 parameter 넘기는 방법 */
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3 (Model model, String str, int num) {
		// 함수의 param 이름은 넘겨받은 param의 이름과 같아야 한다
		
		// String str = request.getParameter("str");
		// String num = request.getParameter("num");
		// 이렇게 param을 하나하나 받아오는게 너무 귀찮음
		// 그래서 param을 아예 함수에 선언
		
		model.addAttribute("str", str);
		model.addAttribute("num", num);
		
		return "test3";
	}
	
	/* test4의 form을 위한 이동 */
	@RequestMapping(value = "/test4home", method = RequestMethod.GET)
	public String test4home () {
		return "test4";
	}
	
	/* POST로 parameter 넘기는 방법 */
	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public String test4 (Model model, String name, String phone, String address) {
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		model.addAttribute("address", address);
		
		// 이 방법도 어느 정도 귀찮은게 있다 그래서 test5에서는 다른 방법을 이용
		
		return "test4Result";
	}
	
	@RequestMapping(value = "test5", method = RequestMethod.GET)
	public String test5 () {
		return "test5";
	}
	
	@RequestMapping(value = "test5Result", method = RequestMethod.POST)
	public String test5Result(PersonVO vo, String etc, Model model) {
		// 알아서 parameter를 가져와 vo 객체를 만들어준다
		// 다만 param name과 vo 클래스의 field name이 같은 애들만 설정해준다
		model.addAttribute("vo", vo);
		
		// 그런데 vo 클래스의 field에 포함 안 되는 애들은 어떻게 받아올 것이냐?
		// 함수의 param에 써주면 된다
		model.addAttribute("etc", etc);
		
		
		return "test5Result";
	}
}











