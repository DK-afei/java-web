<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>展示</title>
</head>
<body>
	<%
		Connection conn = null;
  	 	Statement stmt = null;
  	 	ResultSet rs = null;
		try{
		    //初始化名称查找上下文
		    Context ctx = new InitialContext();
		    //取得DataSource实例,()中为JNDI名称
		    DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/user");
		    //取得数据库连接
		    conn = ds.getConnection();
		} catch(Exception e) {
		    e.printStackTrace();
		} 
	%>
		    <!-- 若不为空，则已连接 -->
		    <%=conn %>
	<%
		String sql = "select * from vote";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		 out.print("<br>");
		%>
	     <table border="1" align="center">
		<tr bgcolor="yellow">
			<td>编号</td>
			<td>姓名</td>
			<td>得票数</td>
			<td>投票</td>
		</tr>
		<%
		while(rs.next()){
		%>
		<tr bgcolor="pink">
					<td><%= rs.getString("tno") %></td>
					<td><%= rs.getString("tname") %></td>
					<td><img src="./jindu.jpg" width="<%= rs.getString("tvote") %>" height="10"><%= rs.getString("tvote") %></td>
					<td><a href="vote.jsp?id=<%=rs.getString("tno")%>" >投票</a></td>
		</tr>
		<%} %>
		</table>
		<%
		try{
		    //将数据库连接放回池中
		    rs.close();
		 	stmt.close();
		    conn.close();
		} catch(Exception e) {
		    e.printStackTrace();
		}
		%>
</body>
</html>