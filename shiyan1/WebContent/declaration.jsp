<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int count=0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP声明</title>
</head>
<body>
	<% out.println("页面刷新次数："+count); %>
	<% count++; %>
</body>
</html>