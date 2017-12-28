<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="./rsrc/js/test.js"></script>
		<title>[ JS Page ]</title>
	</head>
	<body>
		<p>
			<a href="javascript:test1()">function 1</a>
		</p>
		
		<a href="javascript:test1()">
			<img src="./rsrc/img/1.jpg">
		</a>
		
		<br>
		
		<input type="button" onclick="test1()" value="1번째 값">
		
		<br>
		
		<a href="javascript:test2(10)">function 2</a>
		
		<br>
		
		<a href="javascript:test3('10', '20')">function 3</a>
		
		<br>
		
		<input type="text" id="left">
		<input type="text" id="right">
		<input type="button" value="계산" onclick="test4()">
		
		<br>
		
		<input type="button" value="추가" onclick="test5()">
		
		<div id="box">
		
		</div>
		
		
	</body>
</html>













