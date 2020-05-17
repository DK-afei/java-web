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
            // ע�� JDBC ����
            Class.forName(driver);
        
            // ������
            out.println("�������ݿ�...");
            out.print("<br>");
            conn = DriverManager.getConnection(url,user,password);
        
            // ִ�в�ѯ
            out.println(" ʵ����Statement����...");
            out.print("<br>");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM emp where eid=6";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int eid  = rs.getInt("eid");
                String ename = rs.getString("ename");
                String dept = rs.getString("dept");
                java.util.Date entry = rs.getDate("entry");
                double wage = rs.getDouble("wage");
                double bonus = rs.getDouble("bonus");
                
    
                // �������
                out.print("id: " + eid);
                out.print(", ����: " + ename);
                out.print(", ����: " + dept);
                out.print(", ��ְʱ��: " + entry);
                out.print(", ����: " + wage);
                out.print(", ����: " + bonus);
                out.println("<br>");
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
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
