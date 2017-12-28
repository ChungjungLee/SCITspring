<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ JPY/DOLLAR Form ]</title>
	</head>
	<body>
		<form action="jpydollar" method="POST">
			<input type="text" name="won">
			<!-- 실제로 form이 들고 가는 것은 select가 넘어간다 with option value -->
			<select name="select">
				<option>JPY</option>
				<option>USD</option>
				<option>CNY</option>
			</select>
			<input type="submit" value="변환">
		</form>
	</body>
</html>