package shiyan3;

import java.sql.*;
 
public class TestJDBC {
 
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    
    static final String USER = "root";
    static final String PASS = "123321";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM emp";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("eid");
                String name = rs.getString("ename");
                String dept = rs.getString("dept");
                java.util.Date entry = rs.getDate("entry");
                double wage = rs.getDouble("wage");
                double bonus = rs.getDouble("bonus");
                
    
                // 输出数据
                System.out.print("id: " + id);
                System.out.print(", 姓名: " + name);
                System.out.print(", 部门: " + dept);
                System.out.print(", 入职时间: " + entry);
                System.out.print(", 工资: " + wage);
                System.out.print(", 奖金: " + bonus);
                System.out.print("\n");
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
        System.out.println("Goodbye!");
    }
}