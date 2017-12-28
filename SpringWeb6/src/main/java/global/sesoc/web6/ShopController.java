package global.sesoc.web6;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web6.vo.ProductVO;

@Controller
public class ShopController {
	
	private ArrayList<ProductVO> getShopList() {
		ArrayList<ProductVO> list = new ArrayList<>();
		list.add(new ProductVO(1, "에스프레소", 1000));
		list.add(new ProductVO(2, "아메리카노", 2000));
		list.add(new ProductVO(3, "라떼", 3000));
		list.add(new ProductVO(4, "카푸치노", 4000));
		list.add(new ProductVO(5, "프라푸치노", 5000));
		
		return list;
	}
	
	@RequestMapping (value = "/shopList", method = RequestMethod.GET)
	public String shopListPage(Model model) {
		model.addAttribute("list", getShopList());
		
		return "list";
	}
	
	@RequestMapping (value = "/shopList", method = RequestMethod.POST)
	public String addShopToCart(Integer[] selected, HttpServletResponse response) {
		
		// selected된 상품의 id를 하나의 문자열로 바꿔줘야 한다
		String selectedId = "";
		
		int i = 0;
		for ( ; i < selected.length; i++) {
			selectedId += (selected[i].toString() + "/");
		}
		
		Cookie c = new Cookie("selected", selectedId);
		
		response.addCookie(c);
		
		return "redirect:/";
	}
	
	@RequestMapping (value = "/cart", method = RequestMethod.GET)
	public String cartPage(HttpServletRequest request, Model model) {
		
		Cookie[] cookies = request.getCookies();
		
		/* get selected product ids from cookie */
		String selected = null;
		for (Cookie c : cookies) {
			if (c.getName().equals("selected")) {
				selected = c.getValue(); 
			}
		}
		
		/* get product objects corresponded to the selected id */
		ArrayList<ProductVO> addedCartList = new ArrayList<>();
		if (selected != null) {
			ArrayList<ProductVO> shopList = getShopList();
			
			/* ids parsing */
			String[] splited = selected.split("/");
			for (String split : splited) {
				for (ProductVO shop : shopList) {
					if (shop.getId() == Integer.parseInt(split)) {
						addedCartList.add(shop);
					}
				}
			}
		}
		
		model.addAttribute("list", addedCartList);
		
		return "cart";
	}
	
	@RequestMapping (value = "/drop", method = RequestMethod.GET)
	public String drop(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] cookies = request.getCookies();
		
		// clear all cookies info
		for (Cookie c : cookies) {
			c.setMaxAge(0);
			response.addCookie(c);
		}
		
		return "redirect:/";
	}
}






















