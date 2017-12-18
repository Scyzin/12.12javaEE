package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CRUD {
	@Test
	public void testSelect() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
		
		Statement stmt = conn.createStatement(); 
		ResultSet rs =stmt.executeQuery("select * from users");
		List<User> list = new ArrayList<User>();
		while(rs.next( )){
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		}
		rs.close();
		stmt.close();
		conn.close();
		
		for(User user :list){
			System.out.println(user);
		}
	}
	@Test
	public void testSelect1() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
		
		Statement stmt = conn.createStatement(); 
		ResultSet rs =stmt.executeQuery("select * from users");
		List<User> list = new ArrayList<User>();
		
		rs.afterLast();
		rs.previous();
		
		User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		
		rs.close();
		stmt.close();
		conn.close();
		
			System.out.println(u);
	}
	
	@Test
	public void test1() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		
		Statement stmt = conn.createStatement(); 
		//执行sql
		int i = stmt.executeUpdate("INSERT INTO users VALUES(4,'tom','123','tom@163.com','2015-09-28')");
		if(i>0){
			System.out.println("success 修改了" + i +"行");
		}else{
			System.out.println("执行不到");
		}
		//处理结果
		stmt.close();
		conn.close();
	}
	
	@Test
	public void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		
		Statement stmt = conn.createStatement(); 
		//执行sql
		int i = stmt.executeUpdate("UPDATE users SET NAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=3");
		if(i>0){
			System.out.println("success");
		}else{
			System.out.println("执行不到");
		}
		//处理结果
		stmt.close();
		conn.close();
	}
	@Test
	public void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		
		Statement stmt = conn.createStatement(); 
		//执行sql
		int i = stmt.executeUpdate("DELETE FROM users WHERE id=4");
		if(i>0){
			System.out.println("success ,修改了" +i +"行");
		}else{
			System.out.println("执行不到");
		}
		//处理结果
		stmt.close();
		conn.close();
	}
	
	
	@Test
	public void testSelect3() {
		
		Connection conn = null;
		Statement stmt =null ;
		ResultSet rs =null ;
		List<User> list =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("select * from users");
			list = new ArrayList<User>();
			while(rs.next( )){
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getDate("birthday"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
				}
			if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
			}
			if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
			}
		}
		for(User user :list){
			System.out.println(user);
		}
	}

}
