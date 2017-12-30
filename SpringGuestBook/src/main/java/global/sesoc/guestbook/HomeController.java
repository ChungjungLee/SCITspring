package global.sesoc.guestbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * logger의 level hierarchy
	 * 
	 * public final static int OFF_INT = Integer.MAX_VALUE;
	 * public final static int FATAL_INT = 50000;
	 * public final static int ERROR_INT = 40000;
	 * public final static int WARN_INT  = 30000;
	 * public final static int INFO_INT  = 20000;
	 * public final static int DEBUG_INT = 10000;
	 * public static final int TRACE_INT = 5000;
	 * public final static int ALL_INT = Integer.MIN_VALUE;
	 * 
	 * 값이 작은 애들로 설정하면 그 위에 있는 모든 것들이 출력
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
}
