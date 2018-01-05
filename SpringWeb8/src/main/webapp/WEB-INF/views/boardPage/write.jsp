<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/write.js' />"></script>
		<title>[ 글쓰기 폼 ]</title>
	</head>
	<body>
		<h1>글쓰기 폼</h1>
		
		<form action="write" method="POST" onsubmit="return validation()">
			제목 <input type="text" id="title" name="title"> <br>
			내용 <textarea rows="10" cols="50" id="content" name="content"></textarea> <br>
			<input type="submit" value="작성">
		</form>
	</body>
</html>