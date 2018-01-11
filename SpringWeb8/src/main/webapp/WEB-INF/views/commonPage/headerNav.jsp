<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
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
					<a class="navbar-brand" href="${myContextPath}">홈으로</a>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-naver-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<a href="${myContextPath}/customer/join">회원가입<span class="sr-only"></span></a>
					</li>
					<li class="active">
						<a href="${myContextPath}/customer/login">로그인<span class="sr-only"></span></a>
					</li>
				</ul>
			</div>
		</nav>
	</body>
</html>