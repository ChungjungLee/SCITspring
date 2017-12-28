<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/idCheck.js'/>"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<form action="idCheck" method="POST" onsubmit="return validation()">
			<input type="text" name="id" id="id" value="${param.id}">
			<input type="submit" value="중복체크">
		</form>
		
		<c:if test="${checked == 'checked'}">
			<c:choose>
				<c:when test="${duplicated == 'dup'}">
					중복되어 사용할 수 없는 ID입니다
				</c:when>
				<c:otherwise>
					사용 가능한 ID입니다 <input type="button" value="사용하겠습니다" onclick="use('${param.id}')">
				</c:otherwise>
			</c:choose>
		</c:if>
	</body>
</html>