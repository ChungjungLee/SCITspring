<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<c:url value="/resources/javascript/gugudan.js" />"></script>
		
		<title>Insert title here</title>
		
	</head>
	<body>
		<form action="gugudan" method="POST" onsubmit="return validation();">
			<input type="text" name="input" id="input">
			<input type="submit" value="출력">
		</form>
	</body>
</html>