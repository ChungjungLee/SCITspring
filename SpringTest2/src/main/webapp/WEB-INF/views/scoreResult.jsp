<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>합계 및 평균</title>
	</head>
	<body>
		국어: ${kor}, 영어: ${eng}, 수학: ${mat}
		<br>
		총점: ${sum}, 평균: <fmt:formatNumber value="${avg}" pattern="0.00" />
	</body>
</html>