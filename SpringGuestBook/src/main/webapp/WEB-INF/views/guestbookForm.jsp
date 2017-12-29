<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>방명록 글쓰기</h3>
		
		<form action="guestbookwrite" method="POST">
			이름 <input type="text" name="author">
			<br>
			비밀번호 <input type="password" name="password">
			<br>
			내용 <textarea rows="10" cols="100" name="content"></textarea>
			<br>
			
			<input type="submit" value="저장">
		</form>
	</body>
</html>