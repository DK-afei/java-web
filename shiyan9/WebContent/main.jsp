<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<%
		String uName = (String)session.getAttribute("username");
		if(uName==null)
			response.sendRedirect("form2.jsp");
	%>
	<h1>欢迎<%=session.getAttribute("username") %>登陆</h1>
	<a href="/shiyan9/ServletInvalidate?id=<%=session.getAttribute("username")%>"> 注销 </a>
</body>
</html>