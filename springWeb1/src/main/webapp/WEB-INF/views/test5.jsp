<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ TEST5 페이지 ]</title>
	</head>
	<body>
		<form action="test5Result" method="POST">
			이름: <input type="text" name="name">
			<br>
			전화번호: <input type="text" name="phone">
			<br>
			주소: <input type="text" name="address">
			<br>
			기타: <input type="text" name="etc">
			<br>
			<input type="submit" value="전송">
		</form>
	</body>
</html>