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
		<h3>모든 회원 정보</h3>
		
		<c:forEach var="member" items="${list}">
			ID: <c:out value="${member.id}" /> <br>
			PW: <c:out value="${member.password}" /> <br>
			NAME: <c:out value="${member.name}" /> <br>
			<a href="delete?id=${member.id}">삭제</a>
			<br>
		</c:forEach>
		
	</body>
</html>