<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/joinForm.js'/>"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<form action="join" method="POST">
			ID: <input type="text" name="id" id="id" readonly> 
			<input type="button" value="중복확인" onclick="checkId()"> <br>
			PW: <input type="password" name="password"> <br>
			NAME: <input type="text" name="name"> <br>
			
			<input type="submit" value="가입">
		</form>
	</body>
</html>