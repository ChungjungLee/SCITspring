package global.sesoc.web8.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


// interceptor를 상속 받아야 한다 (adapter pattern을 이용한듯)
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	/* 어떤 메소드를 실행하기 전에 이 함수가 먼저 실행 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("LoginInterceptor 실행");
		logger.info("접속 IP: {}", getClientIP(request));
		// 세션을 받아와서 로그인 아이디가 있는지 확인 필요
		HttpSession session = request.getSession();
		String loginid = (String)session.getAttribute("loginid");
		
		if (loginid == null) {
			// 로그인 창으로 강제로 보냄
			// redirect로 보내줘야 한다(여기랑 상관없이 사용자에게 다른 창으로 이동토록 명령)
			
			// 현재 주소를 얻어 오는 방법이 두 가지 존재했었는데 
			// 1. request로부터 context path(application의 root) 얻어오기
			// 2. JSTL의 url 태그를 이용
			String url = request.getContextPath() + "/customer/login";
			response.sendRedirect(url);
			return false;
		}
		
		return super.preHandle(request, response, handler);
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
	
}




























