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
		String uName = (String)session.getAttribute("name");
		if(uName==null)
			response.sendRedirect("login.jsp");
	%>
	<h1>欢迎<%=session.getAttribute("name") %>登陆</h1>
	<h1>这是您第<%=session.getAttribute("count") %>次登陆</h1>
	<a href="logout.jsp?id=<%=session.getAttribute("name")%>"> 注销 </a>
</body>
</html>