<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/joinForm.js'/>"></script>
		<title>[ 회원가입 ]</title>
	</head>
	<body>
		<c:if test="${errorMessage != null}">
			<p>${errorMessage}</p>
		</c:if>
		
		<!--
			http://localhost:8888/web8/join (controller의 진입 루트를 미지정시)
			http://localhost:8888/web8/customer/join (controller의 진입 루트를 지정시) 
			customer/join이라고 쓰면 customer/customer/join으로 들어간다
			현재 위치가 web8/customer이기 때문
		 -->
		<form action="join" method="POST" onsubmit="return validation()">
			아이디: 
				<input type="text" id="custid" name="custid" value="${customer.custid}" readonly> 
				<input type="button" value="ID중복체크" onclick="javascript:idCheckPage()"> <br>
			비밀번호: <input type="password" id="password" name="password"> <br>
			비밀번호 확인: <input type="password" id="password_c" name="password_c"> <br>
			이름: <input type="text" id="name" name="name" value="${customer.name}"> <br>
			이메일: <input type="text" id="email" name="email" value="${customer.email}"> <br>
			구분: 
				<input type="radio" name="division" value="personal"> 개인
				<input type="radio" name="division" value="company"> 법인 <br>
			주민번호(사업자번호): <input type="text" id="idno" name="idno" value="${customer.idno}"> <br>
			주소: <input type="text" id="address" name="address" value="${customer.address}"> <br>
			
			<input type="submit" value="가입">
		</form>
	</body>
</html>



























