<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投票</title>
</head>
<body>
	<%
		Connection conn = null;
  	 	PreparedStatement ps = null;
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
		String id = request.getParameter("id");
		String sql = "update vote set tvote=tvote+1 where tno=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
		try{
		    //将数据库连接放回池中
		 	ps.close();
		    conn.close();
		} catch(Exception e) {
		    e.printStackTrace();
		}
	%>
	<jsp:forward page="display.jsp"></jsp:forward>
</body>
</html>