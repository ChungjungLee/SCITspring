<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/login.js'/>"></script>
		<title>[Login Page]</title>
	</head>
	<body>
		<form action="login" method="POST" onsubmit="validation()">
			<p>로그인 아이디와 비밀번호를 알아 맞혀야 함</p>
			<input type="text" id="id" name="id" placeholder="ID">
			<input type="password" id="pw" name="pw" placeholder="PASSWORD">
			<input type="submit" value="login">
		</form>
	</body>
</html>