<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>Hello world!</h1>
		
		<P>  The time on the server is ${serverTime}. </P>
		
		<br>
		
		<ul>
			<li>
				<a href="bitcoin">비트코인 환율</a>
			</li>
			<li>
				<a href="jpydollar">엔화/미화 환율</a>
			</li>
			<li>
				<a href="length">길이 변환</a>
			</li>
			<li>
				<a href="gugudan">구구단 출력</a>
			</li>
		</ul>
	</body>
</html>
