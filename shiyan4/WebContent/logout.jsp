<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注销</title>
</head>
	
	<%
		String uName = (String)session.getAttribute("name");
		if(uName==null)
			response.sendRedirect("login.jsp");
		else
			session.invalidate();
	%>
	<h1><%=request.getParameter("id") %>注销成功！</h1>
</body>
</html>