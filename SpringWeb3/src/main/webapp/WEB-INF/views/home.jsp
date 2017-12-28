<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>SpringWeb3</title>
		<script type="text/javascript">
			function changeImg() {
				var eImg2 = document.getElementById('img2');
				eImg2.setAttribute('src', './rsrc/img/cake.jpg');
			}
			
			function changeImgPre() {
				var eImg2 = document.getElementById('img2');
				eImg2.setAttribute('src', './rsrc/img/muffin.jpg');
			}
		</script>
	</head>
	<body>
		<!-- 
			현재 위치는 home.jsp 파일이 존재하는 위치를 말하는게 아니다. 
			이 파일에 접근하기 위한 주소창의 위치를 가리킨다 
			/는 루트
			./는 현재 폴더
			../는 상위 폴더
		-->
		<img src="./rsrc/img/coffee.jpg">
		
		<img src="./rsrc/img/muffin.jpg" id="img2" onmouseover="javascript:changeImg()" 
				onmouseleave="javascript:changeImgPre()" height="200px" width="300px">
				
		<br>
		
		<!-- 우리가 계속 ul, li 태그를 사용하는 이유? 이게 나중에 메뉴가 되기 때문 -->
		<ul>
			<li>
				<a href="image1">이미지1</a>
			</li>
			
			<li>
				<a href="past">선호 커피</a>
			</li>
			
			<li>
				<a href="form">사진 선택</a>
			</li>
			
			<li>
				<a href="practice">JS 연습</a>
			</li>
			
			<li>
				<a href="css">CSS 연습</a>
			</li>
			
			<li>
				<a href="priority">CSS Priority</a>
			</li>
		</ul>
	</body>
</html>
