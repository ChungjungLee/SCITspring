<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/idCheckForm.js'/>"></script>
		<title>[ 아이디 중복체크 ]</title>
	</head>
	<body>
		<form action="idCheckPage" method="POST" onsubmit="return validation()">
			사용하려는 아이디: <input type="text" name="id"> <br>
			
			<input type="submit" value="중복체크">
			
			<br>
			
			<c:if test="${checked == true}">
				<c:choose>
					<c:when test="${duplicated == true}">
						중복된 아이디라 사용할 수 없습니다.
					</c:when>
					<c:otherwise>
						사용할 수 있는 아이디입니다.
						<!-- ${param.id}에 따옴표를 사용하지 않으면 문자열이 아닌 변수명으로 인식한다 -->
						<input type="button" value="사용" onclick="useId('${param.id}')">
					</c:otherwise>
				</c:choose>
			</c:if>
		</form>
	</body>
</html>






























