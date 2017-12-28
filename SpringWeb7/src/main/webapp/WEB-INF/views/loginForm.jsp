<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="login" method="POST">
			ID <input type="text" name="id"> <br>
			PW <input type="password" name="password"> <br>
			
			<input type="submit" value="로그인">
		</form>
		${error}
	</body>
</html>