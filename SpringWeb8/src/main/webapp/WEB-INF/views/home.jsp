<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>[ Web 8 ]</h1>
		
		param: ${param.test} <br>
		
		<ul>
			<li>
				<a href="customer/join">회원가입</a>
			</li>
			<li>
				<a href="customer/login">로그인</a>
			</li>
			<li>
				<a href="customer/test">test</a>
			</li>
		</ul>
	</body>
</html>
