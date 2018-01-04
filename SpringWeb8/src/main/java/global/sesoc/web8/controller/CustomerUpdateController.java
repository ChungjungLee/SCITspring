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
public class CustomerUpdateController {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping (value = "update", method = RequestMethod.GET)
	public String updateForm(HttpSession session, Model model) {
		
		String id = (String) session.getAttribute("loginid");
		
		Customer customer = customerDAO.getCustomerOne(id);
		
		model.addAttribute("customer", customer);
		
		return "customerPage/updateForm";
	}
	
	@RequestMapping (value = "update", method = RequestMethod.POST)
	public String update(Customer customer) {
		
		
		
		return "";
	}
}


























