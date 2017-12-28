<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ 영화 정보 입력 ]</title>
	</head>
	<body>
		
		<form action="input" method="POST">
			제목: <input type="text" name="title">
			<br>
			감독: <input type="text" name="director">
			<br>
			평점: <input type="text" name="stars">
			<br>
			<input type="submit" value="전송">
		</form>
	</body>
</html>