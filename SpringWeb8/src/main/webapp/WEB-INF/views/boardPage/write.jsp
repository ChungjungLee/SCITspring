<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- CSS 파일 -->
		<link type="text/css" href="<c:url value='/resources/css/write.css'/>" rel="stylesheet">
		<!-- Javascript -->
		<script type="text/javascript" src="<c:url value='/resources/js/write.js' />"></script>
		<title>[ 글쓰기 폼 ]</title>
	</head>
	<body>
		<h1>글쓰기 폼</h1>
		
		<form action="write" method="POST" onsubmit="return validation()" enctype="multipart/form-data">
			<c:choose>
				
				<c:when test="${action == 'update'}">
					제목 <input type="text" id="title" name="title" value="${board.id}"> <br>
					내용 <textarea rows="10" cols="50" id="content" name="content">${board.content}</textarea> <br>
					파일 
					<c:forEach var="attachment" items="${attachmentList}">
						${attachment.originalfile} 
						<button class="replace">파일 변경</button>
						<input type="file" name="uploads" class="upload"> 
						<input type="button" value="삭제" onclick="javascript:deleteAttach(${attachment.attachmentnum})">
						<br>
					</c:forEach>
					<input type="submit" value="수정" formaction="update">
					<input type="hidden" name="boardnum" value="${board.boardnum}">
				</c:when>
				
				<c:otherwise>
					제목 <input type="text" id="title" name="title"> <br>
					내용 <textarea rows="10" cols="50" id="content" name="content"></textarea> <br>
					<!-- input file만 쓴다고 파일이 업로드 되지는 않는다, 폼에 속성을 추가해야 한다 -->
					파일 <input type="file" name="uploads" multiple> <br>
					<input type="submit" value="작성">
				</c:otherwise>
				
			</c:choose>
		</form>
	</body>
</html>