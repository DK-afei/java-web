<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="javax.naming.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%
    Connection conn = null;
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
try{
    //将数据库连接放回池中
    conn.close();
} catch(Exception e) {
    e.printStackTrace();
}
%>

</body>
</html>