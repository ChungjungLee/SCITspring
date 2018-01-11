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
		
		<form action="write" method="POST" id="form" onsubmit="return validation()" enctype="multipart/form-data">
			<c:choose>
				
				<c:when test="${action == 'update'}">
					제목 <input type="text" id="title" name="title" value="${board.id}"> <br>
					내용 <textarea rows="10" cols="50" id="content" name="content">${board.content}</textarea> <br>
					파일 
					
					<c:forEach var="attachment" items="${attachmentList}">
						<div id="file_${attachment.attachmentnum}" class="file">
							<input type="text" id="file_name_${attachment.attachmentnum}"
									class="file_name" value="${attachment.originalfile}" readonly>
						
							<div class="file_input_div">
								<input type="button" value="파일 변경" class="file_input_button" />
								<input type="file" class="file_input_hidden" name="uploads"
										onchange="javascript:fileEdit(${attachment.attachmentnum}, this.value)" />
							</div>
							
							<input type="button" value="파일 삭제" onclick="javascript:fileDelete(${attachment.attachmentnum})">
							<br>
						</div>
						
						<input type="hidden" name="attachmentnums" value="${attachment.attachmentnum }">
					</c:forEach>
					<!-- <input type="button" value="파일 추가" onclick="javascript:fileAdd()"> -->
					
					<hr>
					<input type="submit" value="글 수정" formaction="update">
					<input type="hidden" id="boardnum" name="boardnum" value="${board.boardnum}">
					<input type="hidden" id="editnums" name="editnums" value="">
					<input type="hidden" id="deletenums" name="deletenums" value="">
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



<!-- onclick="javascript:fileEditLog(${attachment.attachmentnum})"  -->