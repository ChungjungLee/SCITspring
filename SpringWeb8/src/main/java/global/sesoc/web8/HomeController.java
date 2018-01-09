package global.sesoc.web8;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static ArrayList<Long> primeList = new ArrayList<Long>();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		logger.info("Welcome web8");
		logger.info("접속IP: {}", getClientIP(request));
		//getEuler3();
		return "home";
	}
	
	private String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
		}

		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr() ;
		}
		
		return ip;
	}
	
	
	private void getEuler3() {
		long x = 2L;
		long N = 600851475143L;
		
		while (true) {
			if (N % x == 0 && N / x == 1) {
				break;
			}
			
			if (!isPrime(x)) {
				x++;
				continue;
			} else {
				while (N % x ==0) {
					N = N / x;
				}
			}
		}
		
		System.out.println("max: " + x);
	}
	
	private boolean isPrime(long x) {
		//primeList
		for (Long i : primeList) {
			if (x % i == 0) {
				return false;
			}
		}
		
		primeList.add(x);
		
		return true;
	}
	
}




























