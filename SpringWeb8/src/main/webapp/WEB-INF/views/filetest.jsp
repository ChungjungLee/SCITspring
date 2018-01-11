<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/filetest.css"/>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<input type="text" id="fileName" class="file_input_textbox" readonly="readonly">
 
		<div class="file_input_div">
			<input type="button" value="Search files" class="file_input_button" />
			<input type="file" class="file_input_hidden" onchange="javascript: document.getElementById('fileName').value = this.value" />
		</div>
	</body>
</html>