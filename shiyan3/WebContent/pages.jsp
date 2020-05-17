<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%@ include file="morepages.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数据库链接</title>
</head>
<body>
					
			
	<%
			 Connection conn = null;
		   	 Statement stmt = null;
		   	int cP = 1;
	        try{
	            // 注册 JDBC 驱动
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123321");
	        
	            // 执行查询
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            String sql;
	            sql = "SELECT * FROM student";
	            ResultSet rs = stmt.executeQuery(sql);
	        	rs.last();
	        	totalCount = rs.getRow();
	        	totalPages = ((totalCount%E==0)?( totalCount/E):( totalCount/E+1));
	        	String s = request.getParameter("currentPage");
	        	if(s!=null)
	        	cP = Integer.parseInt(s);
	        	p = (cP-1)*E+1;
	        	rs.absolute(p);
	    %>       
	     <table border="1">
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>专业</td>
		</tr>
		<%
			for(int i=p; i<p+E; i++){
		%>
		<tr>
					<td><%= rs.getString("id") %></td>
					<td><%= rs.getString("name") %></td>
					<td><%= rs.getString("sex") %></td>
					<td><%= rs.getInt("age") %></td>
					<td><%= rs.getString("department") %></td>
		</tr>
		<%
				if(!rs.next())
					break;
					
			}
		%>
		</table>
		
		<%
	            // 完成后关闭
	            rs.close();
	            stmt.close();
	            conn.close();
	        }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }finally{
	            // 关闭资源
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// 什么都不做
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
	%>
</body>
</html>