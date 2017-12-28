<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>멤버 관리</h1>
		
		<ul>
			<c:choose>
				<c:when test="${sessionScope.userId == null}">
					<li>
						<a href="join">가입</a>
					</li>
					<li>
						<a href="login">로그인</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<c:out value="${sessionScope.userId}" /> 
						<a href="logout">로그아웃</a>
					</li>
					<li>
						<a href="info">회원 정보</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</body>
</html>
