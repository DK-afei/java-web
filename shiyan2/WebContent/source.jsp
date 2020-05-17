<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>源文件</title>
</head>
<body>
	<% java.util.Date current_time =  new java.util.Date();
	   String date = current_time.toLocaleString();
	   request.setAttribute("current_time", date); 
	%>
	<jsp:forward page="target.jsp"></jsp:forward>
</body>
</html>