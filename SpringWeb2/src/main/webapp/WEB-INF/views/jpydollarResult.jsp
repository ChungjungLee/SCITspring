<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ JPY/DOLLAR Result ]</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${select eq 'JPY'}">
				<fmt:formatNumber type="currency" currencySymbol="JPY " 
						minFractionDigits="2" value="${result}"/>
			</c:when>
			<c:when test="${select.equals('USD')}">
				<fmt:formatNumber type="currency" currencySymbol="USD " 
						minFractionDigits="2" value="${result}"/>
			</c:when>
			<c:otherwise>
				<fmt:formatNumber type="currency" currencySymbol="CNY " 
						minFractionDigits="2" value="${result}"/>
			</c:otherwise>
		</c:choose>
		
	</body>
</html>