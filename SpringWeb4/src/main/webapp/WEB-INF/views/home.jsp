<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home</title>
	</head>
	<body>
		<ul>
			<li>
				<a href="sessionTest">세션 테스트</a>
			</li>
			
			<c:choose>
				<c:when test="${sessionScope.id == null}">
					<li>
						<a href="login">로그인</a>
					</li>
				</c:when>
				<c:otherwise>
					<p>${sessionScope.id}님 환영합니다</p>
					<li>
						<a href="logout">로그아웃</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			<li>
				<a href="shopList">물품 리스트</a>
			</li>
			
			<li>
				<a href="cart">장바구니</a>
			</li>
			
			<li>
				<a href="test1">test1</a>
			</li>
			
			<li>
				<a href="drop">세션지우기</a>
			</li>
			
		</ul>
	</body>
</html>














