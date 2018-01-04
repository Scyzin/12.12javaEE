package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import util.DBCPUtil;

public class TestJDBC {
	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBCPUtil.getConnection();
			ps = conn.prepareStatement("...");
			
//			...
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBCPUtil.release(conn, ps, null);
		}
		
	}
}
