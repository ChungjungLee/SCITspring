<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- CSS 파일 -->
		<link href="<c:url value='/resources/css/list.css'/>" rel="stylesheet" type="text/css">
		<!-- JavaScript 파일 -->
		<script src="<c:url value='/resources/js/list.js'/>" type="text/javascript"></script>
		<title>[ 글 목록 ]</title>
	</head>
	<body>
		<div class="section">
			<div class="header">
				[게시판]
			</div>
			<div class="expand">
				<div class="informations">
					전체: ${numOfList}
				</div>
				<div class="write-button">
					<input type="button" value="글쓰기" onclick="javascript:gotoWriteForm()">
				</div>
			</div>
			<div class="board">
				<!-- 번호 / 제목 / 작성자 / 조회수 / 등록일 -->
				
				<div class="board-row board-row-header">
					<div class="num">
						번호
					</div>
					<div class="title">
						제목
					</div>
					<div class="author">
						작성자
					</div>
					<div class="hits">
						조회수
					</div>
					<div class="indate">
						등록일
					</div>
				</div>
				
				<c:forEach var="board" items="${list}">
					<div class="board-row">
						<div class="num">
							${board.boardnum}
						</div>
						<div class="title">
							<a href="read?boardnum=${board.boardnum}">
								<c:out value="${board.title}" />
							</a>
						</div>
						<div class="author">
							<c:out value="${board.id}" />
						</div>
						<div class="hits">
							${board.hits}
						</div>
						<div class="indate">
							${board.inputdate}
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="navi">
				<div class="pagination">
					페이지네이션
				</div>
				<div class="searchbar">
					제목: <input type="text"> <input type="submit" value="검색">
				</div>
			</div>
		</div>
	</body>
</html>
























