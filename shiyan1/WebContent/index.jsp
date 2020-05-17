<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp引入header和footer</title>
</head>
<body>
	<jsp:include page="header.html"></jsp:include>
	<h1>index.jsp</h1>
	<jsp:include page="declaration.jsp"></jsp:include>
	<br>
	<img alt="index.jpg" src="index.jpg">
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>