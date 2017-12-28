<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ 영화 정보 출력 ]</title>
	</head>
	<body>
		<table>
			<tr>
				<td>Title</td>
				<td>Director</td>
				<td>Stars</td>
			</tr>
			<core:forEach items="${movieList}" var="movie">
				<tr>
					<td>${movie.title}</td>
					<td>${movie.director}</td>
					<td>${movie.stars}</td>
				</tr>
			</core:forEach>
		</table>
	</body>
</html>