<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ 가입 환영 ]</title>
	</head>
	<body>
		<h1>[ customer/joinComplete.jsp ]</h1>
		
		<h3><c:out value="${id}" />님, 가입을 축하드립니다</h3>
		
		<h3>${customer.idno}</h3>
		
		<a href="login">로그인 하기</a>
	</body>
</html>