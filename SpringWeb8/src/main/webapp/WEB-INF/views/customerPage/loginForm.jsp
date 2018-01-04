<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		param.test: ${param.test}
		param.id: ${param.id}
		session.loginid: ${loginid}
		
		<br>
		
		<form action="login" method="POST">
			id: <input type="text" name="id">
			pw: <input type="text" name="pw">
			<input type="submit" value="login">
		</form>
		<a href="logout">logout</a>
	</body>
</html>