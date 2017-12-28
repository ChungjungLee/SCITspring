<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ Image1 Page ]</title>
	</head>
	<body>
		<!-- 
			현재 위치 			localhost:8888/web3/image1	
				왜? 현재 페이지를 부른 곳이 home.jsp의 링크였고, 그 링크에서 image라고 하는 서블릿을 불렀기 때문
			부르고 싶은 리소스 	localhost:8888/web3/rsrc/img/coffee.jpg
			
		 -->
		<img alt="커피" src="./rsrc/img/coffee.jpg">
		
		<br>
		
		<a href="imageTest/image2">이미지2</a>
	</body>
</html>


















