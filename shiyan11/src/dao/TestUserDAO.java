package dao;


import java.sql.SQLException;
import java.util.List;


import bean.User;


public class TestUserDAO {
	public static void main(String[] args) throws SQLException {
//		 new UserDAO().update("bb", "b");
//		 User user = new UserDAO().queryById("b");
//		 System.out.println(user.getUserid()+" "+user.getUsername()+" "+user.getUserpwd());
		 new UserDAO().insert("004", "d", "dd");
		 List<User> users = new UserDAO().queryAll();
		 for(User user : users)
		 {
			 System.out.println(user.getUserid()+" "+user.getUsername()+" "+user.getUserpwd());
		 }
	}
}
