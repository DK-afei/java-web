<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册结果</title>
</head>
<body>
	<%
    List<String> words = new ArrayList<String>();
	words.add("welcome, "+request.getParameter("name"));
	words.add("your secret is:"+request.getParameter("password"));
    words.add("your sex is:"+request.getParameter("sex"));
    for (String word : words)
    {
    	out.println(word);%>
    	<br>
    <%	
    }
    String[] hobits = request.getParameterValues("hobits");
    out.println("your hibits are:");
    for (String hobit : hobits)
    {
    	out.print(hobit+" ");%>
    <%	
    }
	%>
</body>
</html>