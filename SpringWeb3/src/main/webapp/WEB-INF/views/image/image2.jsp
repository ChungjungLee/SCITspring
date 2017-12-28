<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ Image2 Page ]</title>
	</head>
	<body>
		<!-- image1.jsp 페이지에서 그림을 부르던 것과 똑같이 사용하면 나올까? -->
		<!-- 
			현재 위치 			localhost:8888/web3/imageTest/image2
				왜? 현재 페이지를 부른 곳이 image1.jsp의 링크였고, 그 링크에서 imageTest/image2라고 하는 서블릿을 불렀기 때문
			부르고 싶은 리소스 	localhost:8888/web3/rsrc/img/coffee.jpg
				그래서 상위 폴더로 한 번 이동시켜야 한다
		 -->
		<img alt="커피" src="../rsrc/img/coffee.jpg">
		
		<br>
		
		<!-- 아래와 같이 이름만 쓰게 되면 ./image3 와 같은 뜻이다 -->
		<!-- <a href="image3"></a> -->
		
		<a href="test/image3">이미지3</a>
	</body>
</html>