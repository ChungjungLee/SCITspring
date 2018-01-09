<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Bootstrap 파일 -->
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>">
		<!-- CSS 파일 -->
		<link href="<c:url value='/resources/css/list.css'/>" rel="stylesheet" type="text/css">
		<!-- JavaScript 파일 -->
		<script src="<c:url value='/resources/js/list.js'/>" type="text/javascript"></script>
		<title>[ 글 목록 ]</title>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container-fulid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value='/'/>">홈으로</a>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-naver-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<a href="customer/join">회원가입<span class="sr-only"></span></a>
					</li>
					<li class="active">
						<a href="customer/login">로그인<span class="sr-only"></span></a>
					</li>
				</ul>
			
			</div>
		</nav> <!-- header navigation -->
		
		<div class="section">
			<div class="header">
				[게시판]
			</div>
			<div class="expand">
				<div class="informations">
					검색된 게시글: ${totalCount}
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
				<c:forEach var="board" items="${searchList}">
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
			</div> <!-- board -->
			<div class="navSearch">
				<nav>
					<ul class="pagination">
						<c:if test="${navi.startPageGroup > 1}">
							<li>
								<a href="javascript:search(${navi.startPageGroup - 1})">이전 </a>
							</li>
						</c:if>
						<c:forEach var="p" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
							<c:choose>
								<c:when test="${currentPage == p}">
									<li>
										<span style="font-weight: bolder;">${p}</span>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="javascript:search(${p})">${p} </a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${navi.endPageGroup < navi.totalPageCount}">
							<li>
								<a href="javascript:search(${navi.endPageGroup + 1})">다음 </a>
							</li>
						</c:if>
					</ul>
				</nav>
				<div class="searchbar">
					<!-- 이 폼은 get 방식을 이용 -->
					<form id="searchForm" action="list" method="GET">
						<select name="searchOption">
							<option value="title">제목</option>
							<option value="author">작성자</option>
							<option value="content">글 내용</option>
							<option value="titleAndContent">제목+글 내용</option>
						</select>
						<input type="hidden" id="page" name="pagenum">
						<input type="text" name="searchText" value="${param.searchText}"> 
						<input type="button" value="검색" onclick="javascript:search(1)">
					</form>
				</div>
			</div> <!-- nav -->
		</div>
	</body>
</html>



<!-- 
Another pagination way
<a href="list?pagenum=${p}&searchOption=${param.searchOption}&searchText=${param.searchText}">
	<c:choose>
		<c:when test="${currentPage == p}">
			<span style="font-weight: bolder;">${p}</span>
		</c:when>
		<c:otherwise>
			${p}
		</c:otherwise>
	</c:choose>
</a>
 -->




















