package global.sesoc.test2;

import java.util.Calendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test2.vo.Score;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private final int[] daysList = 
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/score", method = RequestMethod.GET)
	public String goScore() {
		return "scoreForm";
	}
	
	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public String calcScore(Score score, Model model) {
		System.out.println("score post 호출");
		System.out.println(score.getKor());
		System.out.println(score.getEng());
		System.out.println(score.getMat());
		//int sum = kor + eng + mat;
		//double avg = sum / 3.0;
		
		//int sum2 = score.getSum();
		//double avg2 = score.getAvg();
		
//		model.addAttribute("kor", kor);
//		model.addAttribute("eng", eng);
//		model.addAttribute("mat", mat);
//		model.addAttribute("sum", sum);
//		model.addAttribute("avg", avg);
//		
		
		model.addAttribute("kor", score.getKor());
		model.addAttribute("eng", score.getEng());
		model.addAttribute("mat", score.getMat());
		model.addAttribute("sum", score.getSum());
		model.addAttribute("avg", score.getAvg());
		
		return "scoreResult";
	}
	
	@RequestMapping (value = "/days", method = RequestMethod.GET)
	public String goDays(Model model) {
		
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		
		model.addAttribute("year", year);
		
		return "daysForm";
	}
	
	@RequestMapping (value = "/days", method = RequestMethod.POST)
	public String calcDays(Integer year, Integer month, Model model) {
		
		if (year == null || month == null) {
			return "error";
		}
		
		int days = daysList[month - 1];
		
		if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				days = 29;
			}
		}
		
		model.addAttribute("days", days);
		
		return "daysResult";
	}
}
















