<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="imageForm" method="POST">
			<input type="radio" name="select" value="1"> 이미지1
			<input type="radio" name="select" value="2"> 이미지2
			<input type="radio" name="select" value="3"> 이미지3
			
			<input type="submit" value="전송">
		</form>
	</body>
</html>