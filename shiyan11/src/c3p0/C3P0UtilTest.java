package c3p0;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class C3P0UtilTest {

	public static void main(String[] args) throws SQLException {
		DataSource ds = C3P0Util.getDataSource();
		Connection conn = C3P0Util.getConnection();
		if(!conn.isClosed()) {
			System.out.println("获取成功");
		}
		C3P0Util.beginTransaction();
		C3P0Util.commitTransaction();
		C3P0Util.releaseConnection(conn);
		System.out.println("执行完毕");
			
	}

}

