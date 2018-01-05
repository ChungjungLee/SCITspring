<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ 글 읽기 ]</title>
	</head>
	<body>
		<h1>글 읽기 페이지</h1>
		
		글 번호: ${board.boardnum} <br>
		작성자: ${board.id} <br>
		제목: ${board.title}<br>
		내용: ${board.content}<br>
		작성일: ${board.inputdate}<br>
		조회수: ${board.hits}<br>
		
	</body>
</html>