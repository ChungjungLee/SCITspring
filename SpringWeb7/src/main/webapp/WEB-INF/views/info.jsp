<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/update.js'/>"></script>
		<title>Insert title here</title>
	</head>
	<body>
		
		<c:choose>
			<c:when test="${updateMode}">
				<form action="update" method="POST">
					이름: <input type="text" name="name" value="${member.name}"> <br>
					비밀번호: <input type="password" name="password"> <br>
					비밀번호확인: <input type="password" name="password_c"> <br>
					아이디: ${member.id} <br>
					<input type="submit" value="확인">
				</form>
			</c:when>
			<c:otherwise>
				이름: ${member.name} <br>
				아이디: ${member.id} <br>
				<input type="submit" value="수정" onclick="update()">
			</c:otherwise>
		</c:choose>
		
	</body>
</html>