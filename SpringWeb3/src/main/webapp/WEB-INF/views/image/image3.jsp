<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ Image3 Page ]</title>
	</head>
	<body>
		<!-- 
			현재 위치 			localhost:8888/web3/imageTest/test/image3
				왜? 현재 페이지를 부른 곳이 image2.jsp의 링크였고, 그 링크에서 imageTest/test/image3 라고 하는 서블릿을 불렀기 때문
			부르고 싶은 리소스 	localhost:8888/web3/rsrc/img/coffee.jpg
				그래서 상위 폴더로 두 번 이동시켜야 한다
				너무 귀찮으니 간단하게 할 수 있는 방법이 2가지 있다
		 -->
		 
		<!-- 
		 	EL의 pageContext 내장 객체를 이용
		 	request.contextPath를 사용하면 현재 프로젝트 이름을 가져온다
		 -->
		<img src="${pageContext.request.contextPath}/rsrc/img/coffee.jpg">
		
		<br>
		
		<!-- 
			JSTL core tag를 이용
			이게 조금 더 낫다고 한다
		 -->
		<img alt="커피" src="<c:url value='/rsrc/img/coffee.jpg'/>">
		
		
	</body>
</html>














