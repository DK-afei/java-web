import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class JDBCServlet extends HttpServlet {
	private String driver = null;
	private String url = null;
	private String user = null;
	private String password = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String type = "text/html;charset=utf-8";
		resp.setContentType(type);
		PrintWriter out = resp.getWriter();
		 Connection conn = null;
	   	 Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(driver);
        
            // 打开链接
            out.println("连接数据库...");
            out.print("<br>");
            conn = DriverManager.getConnection(url,user,password);
        
            // 执行查询
            out.println(" 实例化Statement对象...");
            out.print("<br>");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM emp where eid=6";
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
                out.println("<br>");
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
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		driver = this.getInitParameter("driver");
		url = this.getInitParameter("url");
		user = this.getInitParameter("user");
		password = this.getInitParameter("password");
	}
	
}
