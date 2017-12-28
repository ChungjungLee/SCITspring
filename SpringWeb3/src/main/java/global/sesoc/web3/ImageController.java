package global.sesoc.web3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImageController {
	
	@RequestMapping (value="/image1", method=RequestMethod.GET)
	public String image1() {
		
		// image라고 하는 폴더 아래 image1 jsp 페이지로 이동
		return "image/image1";
	}
	
	// mapping 주소가 imageTest 폴더 아래 image2 가 된다(실제 폴더가 생성되는 것은 아니고 그런것처럼 보이게)
	@RequestMapping (value="/imageTest/image2", method=RequestMethod.GET)
	public String image2() {
		return "image/image2";
	}
	
	@RequestMapping (value="/imageTest/test/image3", method=RequestMethod.GET)
	public String image3() {
		return "image/image3";
	}
	
	@RequestMapping (value="past", method=RequestMethod.GET)
	public String imageTest(Model model) {
		
		int num = (int)(Math.random() * 3) + 1;
		
		model.addAttribute("num", num);
		
		return "image/past";
	}
	
	@RequestMapping (value="form", method=RequestMethod.GET)
	public String imageForm() {
		return "image/form";
	}
	
	@RequestMapping (value="imageForm", method=RequestMethod.POST)
	public String imageSelect(int select, Model model) {
		model.addAttribute("select", select);
		
		return "image/result";
	}
}





















