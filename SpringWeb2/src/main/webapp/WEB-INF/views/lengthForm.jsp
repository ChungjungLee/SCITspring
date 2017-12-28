<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>[ 길이 변환 form ]</title>
	</head>
	<body>
		<form action="lenconvert" method="POST">
			<input type="text" name="input">
			
			<select name="from">
				<option>mm</option>
				<option>cm</option>
				<option>m</option>
				<option>km</option>
				<option>inch</option>
				<option>ft</option>
				<option>yard</option>
				<option>mile</option>
			</select>
			
			<select name="to">
				<option>mm</option>
				<option>cm</option>
				<option>m</option>
				<option>km</option>
				<option>inch</option>
				<option>ft</option>
				<option>yard</option>
				<option>mile</option>
			</select>
			
			<input type="submit" value="변환">
		</form>
	</body>
</html>