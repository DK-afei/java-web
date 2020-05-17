<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除数据</title>
</head>
<body>
	<%
			 Connection conn = null;
		   	 Statement stmt = null;
	        try{
	            // 注册 JDBC 驱动
	            Class.forName("com.mysql.jdbc.Driver");
	        
	            // 打开链接
	            out.print("连接数据库...");
	            out.print("<br>");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123321");
	        
	            // 执行查询
	            out.print(" 实例化Statement对象...");
	            out.print("<br>");
	            stmt = conn.createStatement();
	            String sql;
	            sql = "DELETE FROM emp WHERE eid='11'";
				int i = stmt.executeUpdate(sql);      
				out.println("成功删除"+i+"行");
				out.print("<br>");
	            // 完成后关闭
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
	        out.println("Goodbye!");
	
	
	
	
	
	%>
</body>
</html>