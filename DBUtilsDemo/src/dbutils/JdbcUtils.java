package dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
 
import com.mchange.v2.c3p0.ComboPooledDataSource;

import bean.Student;
import c3p0.C3P0Util;
 
public class JdbcUtils {
	
	public QueryRunner runner = null;
	public DataSource ds = null;
	public Connection conn = null;
	
	
	public JdbcUtils() throws SQLException {
		init();
	}
	public void init() throws SQLException
	{
		this.ds = C3P0Util.getDataSource();
		this.conn = C3P0Util.getConnection();
		if(!conn.isClosed()) {
			System.out.println("��ȡ�ɹ�");
		}
		C3P0Util.beginTransaction();
		C3P0Util.commitTransaction();
		C3P0Util.releaseConnection(conn);
		System.out.println("ִ�����");
		this.runner = new QueryRunner(ds);
	}
	// ��ѯ��������
	public ArrayList<Student> queryAll() {
 
		ArrayList<Student> list = null;
		
		String sql = "select * from student";
		try {
			
			//��ѯ��������,�������ݴ��뼯����
			list = (ArrayList<Student>) runner.query(sql, new BeanListHandler<Student>(Student.class));
 
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
		return list;
	}
//��ѧ�Ų�ѯ���� ����student����
	public Student queryById() {
		Student queryResult = null;
		
		String sql = "select * from student where stuId=?";
		try {
			queryResult = runner.query(sql, new BeanHandler<Student>(Student.class), "20170831005");
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
		return queryResult;
	}
 
	//��������
	public void update(int math,String stuId){
		String sql="update student set math=? where stuId=?";
		try {
			int rows = runner.update(sql, math,stuId);
			if(rows>0){
				System.out.println("���³ɹ�");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	//��������
	public void insert(String stuId,String stuName,String stuSex,int chinese,int math,int english,int classId){
		String  sql="insert into student values(?,?,?,?,?,?,?)";
		
		try {
			int rows = runner.update(sql,stuId,stuName,stuSex,chinese,math,english,classId);
			if (rows>0) {
				System.out.println("����ɹ�");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}