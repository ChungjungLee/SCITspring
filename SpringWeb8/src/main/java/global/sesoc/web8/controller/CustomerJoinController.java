package global.sesoc.web8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import global.sesoc.web8.dao.CustomerDAO;
import global.sesoc.web8.vo.Customer;

@Controller
/* 이 컨트롤러에 접근하려면 아래의 주소를 앞에 명시해야 한다
 * 즉, /customer/join 등과 같이 사용해야 한다
 * */
@RequestMapping("customer")
@SessionAttributes("customer")
public class CustomerJoinController {
	
	/**
	 * sqlSession 사용하던 것 처럼 얘도 이미 생성은 되어있고
	 * 사용하려면 마찬가지로 autowired annotation을 사용
	 */
	@Autowired
	CustomerDAO customerDAO;
	
	// /customer/join
	@RequestMapping (value = "join", method = RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "customer/joinForm";
	}
	
	@RequestMapping (value = "join", method = RequestMethod.POST)
	public String join(
			@ModelAttribute("customer") Customer customer, Model model) {
		
		// session에 customer key로 저장 되어있는 값을 parameter로부터 넘겨받은 값으로 업데이트 시켜준다 자동으로
		
		
		// 이제까지는 sqlSession을 여기서 불렀는데 앞으로는 DAO에서 부르도록 하겠다
		int result = customerDAO.insert(customer);
		
		if (result == 0) {
			model.addAttribute("errorMessage", "가입 실패");
			
			// 가입 실패했을 경우, 가입폼으로 다시 돌아감
			// 값을 다시 입력하게 하기 위해서
			// 사용자가 입력한 값을 들고 forward를 하려고 하는데 model을 이용하지 않음
			// model.addAttribute("customer", customer);
			
			/* joinForm.jsp는 여기서도 사용되고 위에서도 사용이 되는데 그 두 경우를 어떻게 나눌것인가? */
			return "customer/joinForm";
		} 
		
		return "redirect:joinComplete";
	}
	
	/* 좀 성가신 유저는 이 함수를 직접 접근할 수 있다. 그러면 안 되므로 sessionAttribute를 사용 */
	@RequestMapping (value = "joinComplete", method = RequestMethod.GET)
	public String joinComplete(
			SessionStatus status, 
			Model model, 
			@ModelAttribute("customer") Customer customer) {
		
		status.setComplete();
		
		// 뭐가 가입된건지 알려주기 위함
		model.addAttribute("id", customer.getCustid());
		
		
		return "customer/joinComplete";
	}
}

























