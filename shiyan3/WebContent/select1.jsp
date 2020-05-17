<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询数据</title>
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
	            sql = "SELECT * FROM emp";
	            ResultSet rs = stmt.executeQuery(sql);
	        
	            // 展开结果集数据库
	            while(rs.next()){
	                // 通过字段检索
	                int eid  = rs.getInt("eid");
	                String ename = rs.getString("ename");
	                String dept = rs.getString("dept");
	                java.util.Date entry = rs.getDate("entry");
	                double wage = rs.getDouble("wage");
	                double bonus = rs.getDouble("bonus");
	                
	    
	                // 输出数据
	                out.print("id: " + eid);
	                out.print(", 姓名: " + ename);
	                out.print(", 部门: " + dept);
	                out.print(", 入职时间: " + entry);
	                out.print(", 工资: " + wage);
	                out.print(", 奖金: " + bonus);
	                out.print("<br>");
	            }
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
	        out.println("Goodbye!");
	
	
	
	
	
	%>
</body>
</html>