<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<fmt:formatNumber type="number" minFractionDigits="2" value="${input}"/>
		${from } 은
		<fmt:formatNumber type="number" minFractionDigits="2" value="${result}"/>
		${to }
	</body>
</html>