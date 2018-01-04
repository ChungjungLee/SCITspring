package global.sesoc.web8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web8.dao.CustomerDAO;
import global.sesoc.web8.vo.Customer;

@Controller
@RequestMapping("customer")
public class CustomerLoginController {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping (value = "login", method = RequestMethod.GET)
	public String loginForm() {
		return "customerPage/loginForm";
	}
	
	@RequestMapping (value = "login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpSession session, Model model) {
		
		Customer customer = customerDAO.getCustomerOne(id);
		
		// 중복인지 아닌지 표시
		if (customer == null) {
			return "redirect:login";
		}
		
		if (!customer.getPassword().equals(pw)) {
			/* 로그인 실패 */
			return "redirect:login";
		} else {
			/* 로그인 성공 */
			session.setAttribute("loginid", id);
			return "redirect:/";
		}
	}
	
	@RequestMapping (value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginid");
		
		return "redirect:/";
	}
}
