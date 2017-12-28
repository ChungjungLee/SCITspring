<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<c:url value="/resources/js/days.js" />"></script>
		<title>년도 및 월 입력</title>
	</head>
	<body>
		<form action="days" method="POST" onsubmit="">
			연도: <input type="text" name="year" id="year">
			월: <input type="text" name="month" id="month">
			<input type="submit" value="구하기">
		</form>
	</body>
</html>