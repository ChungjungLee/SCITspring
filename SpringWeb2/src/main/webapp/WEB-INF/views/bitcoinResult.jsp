<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ Bitcoin Result ]</title>
	</head>
	<body>
		<h1>Bitcoin Result</h1>
		
		<fmt:formatNumber value="${result}" />
		
		<br>
		
		<a href="bitcoin">돌아가기</a>
		
	</body>
</html>