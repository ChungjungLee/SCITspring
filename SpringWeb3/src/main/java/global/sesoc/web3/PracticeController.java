package global.sesoc.web3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PracticeController {
	
	@RequestMapping (value="practice", method=RequestMethod.GET)
	public String practice() {
		return "practice/js";
	}
	
	@RequestMapping (value="css", method=RequestMethod.GET)
	public String css() {
		return "practice/css";
	}
	
	@RequestMapping (value="/priority", method=RequestMethod.GET)
	public String priority() {
		return "practice/priority";
	}
	
	
}
