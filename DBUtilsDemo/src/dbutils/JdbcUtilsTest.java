package dbutils;

import java.sql.SQLException;
import java.util.List;


import bean.Student;


public class JdbcUtilsTest {
	public static void main(String[] args) throws SQLException {
		 List<Student> students = new JdbcUtils().queryAll();
		 for(Student student : students)
		 {
			 System.out.println(student.getStuId()+" "+student.getStuName()+" "+
					 			student.getStuSex()+" "+student.getChinese()+" "+
					 			student.getMath()+" "+student.getEnglish()+" "+
					 			student.getClassId());
		 }
		
	}
}
