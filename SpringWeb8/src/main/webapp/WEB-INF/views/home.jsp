<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>[ Web 8 ]</h1>
		
		<ul>
			<c:choose>
				<c:when test="${sessionScope.loginid == null}">
					<li>
						<a href="customer/join">회원가입</a>
					</li>
					<li>
						<a href="customer/login">로그인</a>
					</li>
				</c:when>
				<c:otherwise>
					<p>${sessionScope.loginid}님 환영합니다</p>
					<li>
						<a href="customer/update">정보수정</a>
					</li>
					<li>
						<a href="customer/logout">로그아웃</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			<li>
				<a href="customer/test">test</a>
			</li>
		</ul>
	</body>
</html>
