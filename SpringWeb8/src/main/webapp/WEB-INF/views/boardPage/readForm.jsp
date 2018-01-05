<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- CSS 파일 -->
		<link type="text/css" href="<c:url value='/resources/css/readForm.css'/>" rel="stylesheet">
		<!-- JS 파일 -->
		<script type="text/javascript" src="<c:url value='/resources/js/readFrom.js'/>"></script>
		<title>[ 글 읽기 ]</title>
	</head>
	<body>
		<div class="section">
			<div class="header">
				게시판 글 읽기
			</div>
			<div class="content">
				<div>
					작성자
				</div>
				<div>
					${board.id}
				</div>
				<div>
					작성일
				</div>
				<div>
					${board.inputdate}
				</div>
				<div>
					조회수
				</div>
				<div>
					${board.hits}
				</div>
				<div>
					제목
				</div>
				<div>
					${board.title}
				</div>
				<div>
					내용
				</div>
				<div>
					${board.content}
				</div>
				<div>
					파일첨부
				</div>
				<div>
					sample file path
				</div>
			</div>
			<div class="navbar">
				<a href="">삭제</a>
				<a href="">수정</a>
				<a href="list">목록보기</a>
			</div>
			<div class="reply-input">
				<form action="#" method="POST">
					리플내용 
					<input type="text" name="reply"> 
					<input type="submit" value="확인">
				</form>
			</div>
			<div class="reply-content">
				<c:forEach var="reply" items="${replyList}">
					<div>
						<c:out value="${reply.id}" />
					</div>
					<div>
						<c:out value="${reply.text}" />
					</div>
					<div>
						<a href="#">[수정]</a>
					</div>
					<div>
						<a href="#">[삭제]</a>
					</div>
				</c:forEach>
			</div>
		</div>
		
	</body>
</html>