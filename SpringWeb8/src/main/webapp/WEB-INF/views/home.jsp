<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- bootstrap -->
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>">
		<!-- home page용 CSS -->
		<link rel="stylesheet" href="<c:url value='/resources/css/home.css'/>">
		<title>Home</title>
	</head>
	<body>
	
	
		<nav class="navbar navbar-default">
			<div class="container-fulid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="./">홈으로</a>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-naver-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<a href="customer/join">회원가입<span class="sr-only"></span></a>
					</li>
					<li class="active">
						<a href="customer/login">로그인<span class="sr-only"></span></a>
					</li>
				</ul>
			
			</div>
		</nav>
		
		
		<div class="container">
			<div class="jumbotron">
				<h1 class="text-center">[ Web 8 ]</h1>
			</div>

			<ul>
				<c:choose>
					<c:when test="${sessionScope.loginid == null}">
						<li><a href="customer/join">회원가입</a></li>
						<li><a href="customer/login">로그인</a></li>
					</c:when>
					<c:otherwise>
						<p>
							<c:out value="${sessionScope.loginid}" />
							님 환영합니다
						</p>
						<li><a href="customer/update">정보수정</a></li>
						<li><a href="customer/logout">로그아웃</a></li>
						<li><a href="board/list?pagenum=1">게시판으로</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="customer/test">test</a></li>
				<li><a href="filetest">file upload test</a></li>
			</ul>
		</div>
	</body>
</html>
