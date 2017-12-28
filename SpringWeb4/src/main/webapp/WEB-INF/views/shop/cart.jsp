<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[My Cart]</title>
	</head>
	<body>
		<!-- table을 사용하는 이유는? -->
		<table>
			<tr>
				<td>이름</td>
				<td>가격</td>
			</tr>
			
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.name}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
		</table>
		
		<br>
		
		<a href="drop">장바구니 비우기</a>
	</body>
</html>