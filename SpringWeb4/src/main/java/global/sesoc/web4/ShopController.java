package global.sesoc.web4;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web4.vo.ProductVO;
import global.sesoc.web4.vo.Test;


@Controller
public class ShopController {
	
	@RequestMapping (value = "/shopList", method = RequestMethod.GET)
	public String shopList(Model model) {
		model.addAttribute("list", getShopList());
		return "shop/list";
	}
	
	private ArrayList<ProductVO> getShopList() {
		ArrayList<ProductVO> list = new ArrayList<>();
		list.add(new ProductVO(1, "에스프레소", 1000));
		list.add(new ProductVO(2, "아메리카노", 2000));
		list.add(new ProductVO(3, "라떼", 3000));
		list.add(new ProductVO(4, "카푸치노", 4000));
		list.add(new ProductVO(5, "프라푸치노", 5000));
		
		return list;
	}
	
	// vo를 이용하려고 할 때 착각하면 안 되는 것들
	// 유저는 결국 html 파일을 받을 뿐이다. 그런데 html 파일에 vo를 넣어서 보낼 수 있는가?
	// 그럴 수 없다. html 파일에는 단순한 문자열 밖에 없다.
	// 객체의 의미는 자바에서 통용되는 것일 뿐이지 html에서는 존재하지 않는다.
	// jsp는 html이 아닌 자바다.
	// 그렇기 때문에 객체가 아닌 물품의 id를 이용할 수 밖에 없다.
	@RequestMapping (value = "/add", method = RequestMethod.GET)
	public String add(int[] abcd, Integer[] abc, HttpSession session) {
		
		
		System.out.println("entered add");
		for (Integer i : abc) {
			System.out.println(i.intValue());
		}
		//String[] checkList = (String[]) session.getAttribute("check");
		
		// TODO: 중복 아닌 기존의 장바구니 물품 유지
		
		// 이렇게 되면 지난 장바구니의 목록도 사라지고 현재 선택한 것만 들어오게 된다.
		//session.setAttribute("check", check);
		session.setAttribute("check", abc);
		
		return "redirect:/";
	}
	
	@RequestMapping (value = "/cart", method = RequestMethod.GET)
	public String shoppingCart(HttpSession session, Model model) {
		// session에 저장되어 있는 목록의 정보(id)
		// String[] check = (String[]) session.getAttribute("check"); 
		System.out.println(session.getAttribute("check").getClass());
		Integer[] check = (Integer[]) session.getAttribute("check");
		for (int i = 0; i < check.length; i++) {
			System.out.println(check[i]);
		}
		// 장바구니 페이지로 보내줄 목록의 정보(product vo)
		ArrayList<ProductVO> resultList = new ArrayList<>();
		
		// 현재 웹페이지에서 선택할 수 있는 물품 정보
		ArrayList<ProductVO> productList = getShopList();
		/*
		if (check != null) {
			for (int i = 0; i < check.length; i++) {
				int id = Integer.parseInt(check[i]);
				for (ProductVO product : productList) {
					if (product.getId() == id) {
						resultList.add(product);
					}
				}
			}
		}
		*/
		model.addAttribute("list", resultList);
		
		return "shop/cart";
	}
	
	@RequestMapping (value = "/drop", method = RequestMethod.GET)
	public String drop(HttpSession session) {
		session.invalidate();
		//session.removeAttribute("check");
		return "redirect:/";
	}
	
	@RequestMapping (value = "/test1", method = RequestMethod.GET) 
	public String test1(HttpSession session) {
		Test test = new Test("name for test object");
		
		ArrayList<Test> testList = new ArrayList<>();
		testList.add(test);
		
		session.setAttribute("test", test);
		
		return "test";
	}
	
	/*
	 * spring mvc framework에서 @RequestMapping annotation은 
	 * 파라미터에서 사용하는 자바빈 객체의 필드 이름과 form을 통해 보내준 정보 중에
	 * 이름이 같은 값이 있으면 해당 자바빈 객체의 property값으로 설정해주는 기능을 제공한다
	 * */
	@RequestMapping (value = "/test2", method = RequestMethod.POST) 
	public String test2(Test hiddenTest, HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("result", hiddenTest);
		
		return "testResult";
	}
}





















