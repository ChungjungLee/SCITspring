<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<!-- 쿠키에 저장된 정보를 출력하려면 cookie.[name].value -->
		<h2>로그인ID: ${cookie}</h2>
		<ul>
			<li>
				<a href="cookie1">쿠키 저장</a>
			</li>
			<li>
				<a href="cookie2">쿠키 확인</a>
			</li>
			<li>
				<a href="cookie3">쿠키 삭제</a>
			</li>
			<li>
				<a href="cookie4">쿠키 가져오기</a>
			</li>
			<li>
				<a href="login">로그인</a>
			</li>
			<li>
				<a href="logout">로그아웃</a>
			</li>
		</ul>
	</body>
</html>
