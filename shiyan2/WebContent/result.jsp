<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>

	<!-- 通过服务端或者客服端跳转进行登陆验证 -->
	<% String s1 = request.getParameter("name"); %>
	<% String s2 = request.getParameter("password"); %>
	<% if("zwsl".equals(s1)&&"123".equals(s2)) {
		%>
		
		<jsp:forward page="success.html"/>
		
		<%
	} else {
		response.sendRedirect("fail.html");/* response对象的sendRedirect()实现重定向 */
	} %>
	
	<!-- 通过自定义提示不进行跳转进行登陆验证 -->
	<%-- <% String s1 = request.getParameter("name"); %>
	<% String s2 = request.getParameter("password"); %>
	<% if("zwsl".equals(s1)&&"123".equals(s2)) {%>
	<h1>Welcome, <%= s1 %></h1>
	<% } else { %>
	<h1>Failed!</h1>
	<% } %> --%>

</body>
</html>