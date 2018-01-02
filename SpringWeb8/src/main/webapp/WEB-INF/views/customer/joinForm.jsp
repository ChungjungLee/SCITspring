<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript">
			function validation() {
				return true;
			}
		</script>
		<title>[ 회원가입 ]</title>
	</head>
	<body>
		<c:if test="${errorMessage != null}">
			<p>${errorMessage}</p>
		</c:if>
		
		
		<!-- customer/join이라고 쓰면 customer/customer/join으로 들어간다
			현재 위치가 web8/customer이기 때문
		 -->
		<form action="join" method="POST" onsubmit="return validation()">
			아이디: <input type="text" name="custid" value="${customer.custid}"> <br>
			비밀번호: <input type="password" name="password"> <br>
			이름: <input type="text" name="name" value="${customer.name}"> <br>
			이메일: <input type="text" name="email" value="${customer.email}"> <br>
			구분: 
				<input type="radio" name="division" value="personal" checked> 개인
				<input type="radio" name="division" value="company"> 법인 <br>
			주민번호(사업자번호): <input type="text" name="idno" value="${customer.idno}"> <br>
			주소: <input type="text" name="address" value="${customer.address}"> <br>
			
			<input type="submit" value="가입">
		</form>
	</body>
</html>



























