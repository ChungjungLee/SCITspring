<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bye</title>
	</head>
	<body>
		<P>  The time on the server is ${serverTime}. </P>
		
		<br>
		
		<a href="test1">TEST1 페이지</a>
		
		<br>
		
		<a href="test2">TEST2 페이지</a>
		
		<br>
		
		<a href="test3?str=home에서 넘겨줌&num=300">TEST3 페이지</a>
		
		<br>
		
		<a href="test4home">TEST4 페이지</a>
		
		<br>
		
		<a href="test5">TEST5 페이지</a>
	</body>
</html>
