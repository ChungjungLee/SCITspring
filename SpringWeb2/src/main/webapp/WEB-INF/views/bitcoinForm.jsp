<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ Bitcoin Form ]</title>
	</head>
	<body>
		<h1>Bitcoin Form</h1>
		
		<!-- action의 주소가 얘를 부른 bitcoin이랑 똑같지만 method가 POST 방식이라 다르다 -->
		<form action="bitcoin" method="POST">
			<input type="text" name="coin">BTC
			<input type="submit" value="전송">
		</form>
	</body>
</html>