<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆验证结果</title>
</head>
<body>
	<%
		int count = 0;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		ResultSet rs = null;
		Connection conn = null;
		String name = null;
		String pwd = null;
		name = request.getParameter("name");;
		pwd = request.getParameter("password");;
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
		String sql1 = "select * from user where username=? and userpwd=?";
		pstm1 = conn.prepareStatement(sql1);
		pstm1.setString(1, name);
		pstm1.setString(2, pwd);
		rs = pstm1.executeQuery();
		if(rs.next())
		{
			String un = rs.getString("username");
			count = rs.getInt("logincount");
			session.setAttribute("name", un);
			session.setAttribute("count", count);
			count++;
		}
		else
		{
			response.sendRedirect("login.jsp");
		} 
		String sql2 = "update user set logincount=? where username=? and userpwd=?";
		pstm2 = conn.prepareStatement(sql2);
		pstm2.setInt(1, count);
		pstm2.setString(2, name);
		pstm2.setString(3, pwd);
		int i = pstm2.executeUpdate();
		if(i==1)
		response.sendRedirect("index.jsp");
	%>
		<%
		try{
		    //将数据库连接放回池中
		    rs.close();
		    pstm1.close();
		    pstm2.close();
		    conn.close();
		} catch(Exception e) {
		    e.printStackTrace();
		}
		%>
</body>
</html>