<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提示</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
	%>
	<h1>用户<%=username%>没有登陆权限，不能登陆！</h1>
	<a href="form2.jsp">登陆</a>
</body>
</html>