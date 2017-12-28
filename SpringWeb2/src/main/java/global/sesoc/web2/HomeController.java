package global.sesoc.web2;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web2.vo.ConverterArr;
import global.sesoc.web2.vo.ConverterEnum;
import global.sesoc.web2.vo.ConverterLen;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ArrayList<ConverterLen> converterList = null;
	HashMap<String, ConverterLen> converterMap = null;
	// 아래와 같이 enum type은 변수로 선언해서는 valueOf()를 사용하지 못한다
	ConverterEnum converterE;
	ConverterArr converterArr;
	
	public HomeController() {
		converterArr = ConverterArr.getInstance();
		
		converterList = new ArrayList<>();
		converterMap = new HashMap<>();
		
		ConverterLen cmToCm = new ConverterLen("cm", "cm", 1);
		ConverterLen mmToCm = new ConverterLen("mm", "cm", 0.1);
		ConverterLen mToCm = new ConverterLen("m", "cm", 100);
		ConverterLen kmToCm = new ConverterLen("km", "cm", 100000);
		ConverterLen inchToCm = new ConverterLen("inch", "cm", 2.54);
		ConverterLen ftToCm = new ConverterLen("ft", "cm", 30.48);
		ConverterLen yardToCm = new ConverterLen("yard", "cm", 91.44);
		ConverterLen mileToCm = new ConverterLen("mile", "cm", 160934);
		
		converterMap.put("cm", cmToCm);
		converterMap.put("mm", mmToCm);
		converterMap.put("m", mToCm);
		converterMap.put("km", kmToCm);
		converterMap.put("inch", inchToCm);
		converterMap.put("ft", ftToCm);
		converterMap.put("yard", yardToCm);
		converterMap.put("mile", mileToCm);
		
		converterList.add(cmToCm);
		converterList.add(mmToCm);
		converterList.add(mToCm);
		converterList.add(kmToCm);
		converterList.add(inchToCm);
		converterList.add(ftToCm);
		converterList.add(yardToCm);
		converterList.add(mileToCm);
	}
	
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
	
	@RequestMapping(value = "/bitcoin", method = RequestMethod.GET)
	public String bitcoin() {
		// WEB-INF/views/bitcoinForm.jsp를 부른다
		return "bitcoinForm";
	}
	
	/* 같은 주소지만 GET POST 방식에 따라서 실행되는 함수가 다르다 */
	@RequestMapping(value = "/bitcoin", method = RequestMethod.POST)
	public String calcBitcoin(double coin, Model model) {
		// 비트코인 환율
		final double WON = 18700000.0;
		double result = coin * WON;
		
		model.addAttribute("result", result);
		
		return "bitcoinResult";
	}
	
	@RequestMapping(value = "/jpydollar", method = RequestMethod.GET)
	public String jpydollar() {
		return "jpydollarForm";
	}
	
	@RequestMapping(value = "/jpydollar", method = RequestMethod.POST)
	public String calcJpydollar(double won, String select, Model model) {
		final double JPY = 100.0 / 970.0;
		final double USD = 1.0 / 1080.0;
		final double CNY = 1.0 / 164.88;
		
		double result = 0.0;
		switch(select) {
			case "JPY":
				result = won * JPY;
				break;
			case "USD":
				result = won * USD;
				break;
			case "CNY":
				result = won * CNY;
				break;
			default:
				break;
		}
		
		model.addAttribute("result", result);
		model.addAttribute("select", select);
		
		return "jpydollarResult";
	}
	
	@RequestMapping(value = "length", method = RequestMethod.GET)
	public String length() {
		return "lengthForm";
	}
	
	@RequestMapping(value = "length", method = RequestMethod.POST)
	public String convertLen(double input, String from, String to, Model model) {
		
		double result = 0;
		
		for (ConverterLen converter : converterList) {
			if (converter.isCorrect(from, "cm")) {
				result = input * converter.getConvert();
				break;
			}
		}
		
		for (ConverterLen converter : converterList) {
			if (converter.isCorrect("cm", to)) {
				result = result / converter.getConvert();
			}
		}
		
		double resultWithMap = 0;
		
		resultWithMap = input * converterMap.get(from).getConvert();
		resultWithMap = resultWithMap * converterMap.get(to).getConvertRev();
		
		model.addAttribute("input", input);
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		model.addAttribute("result", result);
		model.addAttribute("resultWithMap", resultWithMap);
		
		return "lengthResult";
	}
	
	@RequestMapping (value = "/lenconvert", method = RequestMethod.POST)
	public String lenConvert(double input, String from, String to, Model model){
		
		int fromNum = ConverterEnum.valueOf(from).ordinal();
		int toNum = ConverterEnum.valueOf(to).ordinal();
		
		double result = ConverterArr.convertion(input, fromNum, toNum);
		
		model.addAttribute("input", input);
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		model.addAttribute("result", result);
		
		return "lengthResult";
	}
	
	@RequestMapping (value = "/gugudan", method = RequestMethod.GET)
	public String gugudan() {
		return "gugudanForm";
	}
	
	@RequestMapping (value = "/gugudan", method = RequestMethod.POST)
	public String gugudanResult(int input, Model model) {
		
		model.addAttribute("input", input);
		
		return "gugudanResult";
	}
}











