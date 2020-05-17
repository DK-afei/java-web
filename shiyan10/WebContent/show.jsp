<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show</title>
</head>
<body>
		<h1>目前在线人数为<%=application.getAttribute("user") %></h1>
		<a href="/shiyan10/InvalidateServlet">注销用户</a>
</body>
</html>