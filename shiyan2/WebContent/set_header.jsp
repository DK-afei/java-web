<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置HTTP头</title>
</head>
<body>
	<p>页面每3秒刷新一次</p>
	<% 
		response.setHeader("Refresh","3");
		out.print("out.print:");
		out.print("Refreshed!");
	%>
</body>
</html>