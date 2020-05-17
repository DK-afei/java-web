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
			System.out.println("获取成功");
		}
		C3P0Util.beginTransaction();
		C3P0Util.commitTransaction();
		C3P0Util.releaseConnection(conn);
		System.out.println("执行完毕");
		this.runner = new QueryRunner(ds);
	}
	// 查询所有数据
	public ArrayList<Student> queryAll() {
 
		ArrayList<Student> list = null;
		
		String sql = "select * from student";
		try {
			
			//查询所有数据,并将数据存入集合中
			list = (ArrayList<Student>) runner.query(sql, new BeanListHandler<Student>(Student.class));
 
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
		return list;
	}
//按学号查询数据 返回student对象
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
 
	//更新数据
	public void update(int math,String stuId){
		String sql="update student set math=? where stuId=?";
		try {
			int rows = runner.update(sql, math,stuId);
			if(rows>0){
				System.out.println("更新成功");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	//插入数据
	public void insert(String stuId,String stuName,String stuSex,int chinese,int math,int english,int classId){
		String  sql="insert into student values(?,?,?,?,?,?,?)";
		
		try {
			int rows = runner.update(sql,stuId,stuName,stuSex,chinese,math,english,classId);
			if (rows>0) {
				System.out.println("插入成功");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}