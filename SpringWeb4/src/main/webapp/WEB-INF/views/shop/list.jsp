<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[Shop List Page]</title>
	</head>
	<body>
		<form action="add" method="get">
			<table>
				<tr>
					<td>ID</td>
					<td>상품명</td>
					<td>가격</td>
					<td>체크여부</td>
				</tr>
				
				<c:set var="i" value="0"/>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.price}</td>
						<td>
							<input type="number" name="abc" value="123">
						</td>
					</tr>
				</c:forEach>
			</table>
			
			
			<input type="submit" value="담기">
		</form>
	</body>
</html>