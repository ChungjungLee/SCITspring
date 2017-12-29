<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value='/resources/js/guestbookForm.js'/>"></script>
		<title>[방명록]</title>
	</head>
	<body>
		<h3>방명록</h3>
		
		<input type="button" value="글쓰기" onclick="javascript:guestbookWrite()">
		
		<a href="guestbookwrite">글쓰기</a>
		
		<form action="guestbookdelete" method="POST">
			<table>
				<c:forEach var="guestbook" items="${list}">
					<tr>
						<td>
							작성자: ${guestbook.author} <br>
							작성일: ${guestbook.indate} <br>
							${guestbook.content} <br>
							비밀번호: <input type="password" id="pw${guestbook.num}">
							<input type="submit" value="삭제" 
									onclick="javascript:modify(${guestbook.num})">
							<input type="submit" value="수정" formaction="guestbookupdate"
									onclick="javascript:modify(${guestbook.num})">
						</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="clickednum" id="clickednum">
			<input type="hidden" name="password" id="password">
		</form>
		
	</body>
</html>