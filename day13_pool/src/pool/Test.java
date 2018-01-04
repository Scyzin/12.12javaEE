package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSource ds = new MyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();//com.mysql.jdbc.Connection
			ps = conn.prepareStatement("..");
			
//			...
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();//不要关
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
