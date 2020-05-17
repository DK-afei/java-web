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
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM emp";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("eid");
                String name = rs.getString("ename");
                String dept = rs.getString("dept");
                java.util.Date entry = rs.getDate("entry");
                double wage = rs.getDouble("wage");
                double bonus = rs.getDouble("bonus");
                
    
                // �������
                System.out.print("id: " + id);
                System.out.print(", ����: " + name);
                System.out.print(", ����: " + dept);
                System.out.print(", ��ְʱ��: " + entry);
                System.out.print(", ����: " + wage);
                System.out.print(", ����: " + bonus);
                System.out.print("\n");
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
        System.out.println("Goodbye!");
    }
}