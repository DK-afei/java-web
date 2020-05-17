<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! final int E = 5; %>
<%! int totalPages = 0; %>
<%! int totalCount = 0; %>
<%! int p = 0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分页显示</title>
</head>
<body>
	<p>页码：
	<% 
		int cP0=1;
		String s0 = request.getParameter("currentPage");
		if(s0!=null)
		cP0 = Integer.parseInt(s0);
		for(int i=1; i<=totalPages; i++)
		{
			if(i==cP0){
	%>
	<%=i%>	
	<%	
		}else{
	%>
	<a href="pages.jsp?currentPage=<%=i%>"><%=i%></a>
	<%
		
		}
	%>
	
	
	<%
		}
	%>
	  共<%=totalPages%>页，共<%=totalCount %>条记录</p>
	
	
</body>
</html>