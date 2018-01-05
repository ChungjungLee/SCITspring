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
				<div class="col-header">
					작성자
				</div>
				<div class="col-body">
					<c:out value="${board.id}" />
				</div>
				<div class="col-header">
					작성일
				</div>
				<div class="col-body">
					${board.inputdate}
				</div>
				<div class="col-header">
					조회수
				</div>
				<div class="col-body">
					${board.hits}
				</div>
				<div class="col-header">
					제목
				</div>
				<div class="col-body">
					<c:out value="${board.title}" />
				</div>
				<div class="col-header">
					내용
				</div>
				<div class="col-body">
					<c:out value="${board.content}" />
				</div>
				<div class="col-header">
					파일첨부
				</div>
				<div class="col-body">
					sample file path
				</div>
			</div>
			<div class="navbar">
				<a href="">삭제</a>
				<a href="">수정</a>
				<a href="list">목록보기</a>
			</div>
			<div class="reply-input">
				<form action="#" method="POST" onsubmit="return validation()">
					리플내용 
					<input type="text" id="reply" name="reply">
					<input type="hidden" >
					<input type="submit" value="확인">
				</form>
			</div>
			<div class="reply-content">
				<c:forEach var="reply" items="${replyList}">
					<div class="col-header-reply">
						<c:out value="${reply.id}" />
					</div>
					<div class="col-body-reply">
						<c:out value="${reply.text}" />
					</div>
					<div class="reply-menu">
						<a href="#">[수정]</a>
					</div>
					<div class="reply-menu">
						<a href="#">[삭제]</a>
					</div>
				</c:forEach>
			</div>
		</div>
		
	</body>
</html>