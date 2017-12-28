package global.sesoc.web6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*
 * 세션을 이용하는 또 다른 방법: annotation이용
 * 이 컨트롤러 내에서 model에 "data1"라는 이름의 값을 저장하면 세션에도 똑같이 저장하라는 의미
 */
@Controller
@SessionAttributes({"data1", "data2"})
public class StepController {
	
	@RequestMapping (value = "/step1", method = RequestMethod.GET)
	public String step1() {
		return "step";
	}
	
	@RequestMapping (value = "/step2", method = RequestMethod.GET)
	public String step2(Model model) {
		
		// model에 저장하는 순간 알아서 세션에 정보를 저장한다
		model.addAttribute("data1", "step2에서 저장한 값");
		
		return "step";
	}
	
	@RequestMapping (value = "/step3", method = RequestMethod.GET)
	public String step3(Model model, 
			@ModelAttribute("data1") String data1) {
		/*
		 * 지금 사용하고 있는 세션 중에서 "data1"이라는 이름의 값이 있으면
		 * 해당 변수에 집어넣어 준다
		 * 만약에 세션에 값이 없다면 아예 error를 띄운다
		 * 그래서 반드시 단계적으로 밟아 나가는 페이지에서 사용하도록 하는 곳에서 사용
		 * 
		 * 주의할 점: @SessionAttribute()을 지정하지 않으면 form에서 넘어온 파라미터 중에서 찾는다
		 */
		
		// 옛날엔 @RequestParam(name="id")으로 파라미터에서 지정을 해줬어야 했다.
		
		model.addAttribute("data2", "step3에서 저장한 값");
		
		return "step";
	}
	
	@RequestMapping (value = "/step4", method = RequestMethod.GET)
	public String step4(SessionStatus status,
			@ModelAttribute("data1") String data1,
			@ModelAttribute("data2") String data2) {
		/*
		 * session을 지우는 방식이 조금 다르다
		 * session.invalidate()가 아니고 SessionStatus를 이용
		 * 즉, 모든 단계를 다 밟아서 처리가 끝난다는 의미와 일맥상통
		 */
		
		status.setComplete();	// 세션의 모든 값 삭제
		
		
		return "end";
	}
}























