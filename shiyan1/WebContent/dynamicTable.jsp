<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String[] str = {"Java", "C#", "Python", "C++", "R", "php"}; %>
<%! int[] rank = {1, 4, 2, 3, 5, 6}; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>动态表格</title>
</head>
<body>
	<% String str1 = request.getParameter("id"); 
	   out.println(str1);
	%>
	<table border="1">
		<tr>
			<td>自然编号</td>
			<td>语言名称</td>
			<td>目前排名</td>
		</tr>
		<%
			for(int i=0; i<str.length; i++)
			{
		%>
		<tr>
					<td><%= i+1 %></td>
					<td><%= str[i] %></td>
					<td><%= rank[i] %></td>
		</tr>
		<%
			}
		%>
	
	</table>
	
</body>
</html>