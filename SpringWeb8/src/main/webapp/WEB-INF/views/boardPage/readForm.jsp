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
		<script type="text/javascript" src="<c:url value='/resources/js/readForm.js'/>"></script>
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
				<c:if test="${attachmentList != null && attachmentListSize != 0}">
					<div class="">
						<div class="col-header">
							파일첨부
						</div>
						<div class="col-body">
							<c:forEach var="attachment" items="${attachmentList}">
									<a href="download?attachmentnum=${attachment.attachmentnum}">
										${attachment.originalfile}
									</a> <br>
							</c:forEach>
						</div>
					</div>
				</c:if>
			</div>
			<div class="navbar">
				<c:if test="${board.id == sessionScope.loginid}">
					<a href="update?boardnum=${board.boardnum}"> [수정] </a>
					<a href="delete?boardnum=${board.boardnum}"> [삭제] </a>
				</c:if>
				<a href="list"> [목록보기] </a>
			</div>
			<div class="outer">
				<div class="inner">
					<div class="centered">
						<div class="reply-input">
							<form action="../reply/writeReply" method="POST" onsubmit="return validation()">
								리플내용 
								<input type="text" id="replytext" name="text">
								<input type="hidden" value="${board.boardnum}" name="boardnum">
								<input type="submit" value="확인">
							</form>
						</div>
						<div class="reply-content">
							<c:forEach var="reply" items="${replyList}">
								<div class="reply-row">
									<div class="col-header-reply">
										<c:out value="${reply.id}"/>
									</div>
									<div class="col-body-reply" id="replyUpdateText${reply.replynum}">
										<span id="replyText${reply.replynum}"><c:out value="${reply.text}"/></span>
									</div>
									<c:choose>
										<c:when test="${reply.id == sessionScope.loginid}">
											<div class="col-reply-menu">
												<a href="#" onclick="javascript:replyUpdate('${reply.replynum}')" id="updateReplyLink${reply.replynum}">
													[수정]
												</a>
											</div>
											<div class="col-reply-menu">
												<a href="../reply/deleteReply?boardnum=${board.boardnum}&replynum=${reply.replynum}">
													[삭제]
												</a>
											</div>
										</c:when>
										<c:otherwise>
											<div class="col-reply-menu">　</div>
											<div class="col-reply-menu">　</div>
										</c:otherwise>
									</c:choose>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
			<!-- <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/A_small_cup_of_coffee.JPG/275px-A_small_cup_of_coffee.JPG"> -->

			