package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
 
import bean.User;
import c3p0.C3P0Util;
 
public class UserDAO {
	
	public QueryRunner runner = null;
	public DataSource ds = null;
	public Connection conn = null;
	
	
	public UserDAO() throws SQLException {
		init();
	}
	public void init() throws SQLException
	{
		this.ds = C3P0Util.getDataSource();
		this.conn = C3P0Util.getConnection();
//		if(!conn.isClosed()) {
//			System.out.print("获取链接成功，");
//		}
		C3P0Util.beginTransaction();
		C3P0Util.commitTransaction();
		C3P0Util.releaseConnection(conn);
//		System.out.println("执行数据库准备完毕");
		this.runner = new QueryRunner(ds);
	}
	// 查询所有数据
	public ArrayList<User> queryAll() {
 
		ArrayList<User> list = null;
		
		String sql = "select * from user";
		try {
			
			//查询所有数据,并将数据存入集合中
			list = (ArrayList<User>) runner.query(sql, new BeanListHandler<User>(User.class));
 
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
		return list;
	}
//按用户名查询数据 返回User对象
	public User queryById(String username) {
		User queryResult = null;
		
		String sql = "select * from user where username=?";
		try {
			queryResult = runner.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
		return queryResult;
	}
 
	//更新数据
	public void update(String userpwd,String username){
		String sql="update user set userpwd=? where username=?";
		try {
			int rows = runner.update(sql, userpwd,username);
			if(rows>0){
				System.out.println("更新成功");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	//插入数据
	public void insert(String userid,String username,String userpwd){
		String  sql="insert into user values(?,?,?)";
		
		try {
			int rows = runner.update(sql,userid,username,userpwd);
			if (rows>0) {
				System.out.println("插入成功");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}