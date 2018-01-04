<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ 회원 정보 수정 ]</title>
	</head>
	<body>
		<form action="update" method="POST" onsubmit="return validation()">
			아이디: 
				<input type="text" id="custid" name="custid" value="${customer.custid}" readonly> <br>
			비밀번호: <input type="password" id="password" name="password"> <br>
			비밀번호 확인: <input type="password" id="password_c" name="password_c"> <br>
			이름: <input type="text" id="name" name="name" value="${customer.name}"> <br>
			이메일: <input type="text" id="email" name="email" value="${customer.email}"> <br>
			구분: 
				<c:choose>
					<c:when test="${customer.division == 'personal'}">
						<input type="radio" name="division" value="personal" checked> 개인
						<input type="radio" name="division" value="company"> 법인 <br>
					</c:when>
					<c:otherwise>
						<input type="radio" name="division" value="personal"> 개인
						<input type="radio" name="division" value="company" checked> 법인 <br>
					</c:otherwise>
				</c:choose>
			주민번호(사업자번호): <input type="text" id="idno" name="idno" value="${customer.idno}"> <br>
			주소: <input type="text" id="address" name="address" value="${customer.address}"> <br>
			
			<input type="submit" value="수정">
		</form>
	</body>
</html>