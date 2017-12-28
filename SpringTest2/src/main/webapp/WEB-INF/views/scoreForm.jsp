<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<c:url value="/resources/js/score.js" />"></script>
		
		<title>성적 입력</title>
	</head>
	<body>
		<!-- onsubmit은 value가 참인지 거짓인지에 따라서 submit의 여부를 결정하는 애 -->
		<form action="score" method="POST" onsubmit="">
			국어: <input type="text" name="kor" id="kor"> <br>
			영어: <input type="text" name="eng" id="eng"> <br>
			수학: <input type="text" name="mat" id="mat"> <br>
			<input type="submit" value="합계 및 평균">
		</form>
	</body>
</html>