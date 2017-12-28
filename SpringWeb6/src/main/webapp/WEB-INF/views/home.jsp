<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h5>${cookie.selected.value}</h5>
		<ul>
			<li>
				<a href="step1">Step1</a>
			</li>
			<li>
				<a href="shopList">쇼핑하기</a>
			</li>
			<li>
				<a href="cart">장바구니</a>
			</li>
		</ul>
		
	</body>
</html>
