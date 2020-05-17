<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp引入header和footer</title>
</head>
<body>
	<jsp:include page="header.html"></jsp:include>
	<h1>main.jsp</h1>
	<jsp:include page="declaration.jsp"></jsp:include>
	<br>
	<img alt="main.jpg" src="main.jpg">
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>