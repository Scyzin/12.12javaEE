package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

//使用jdbc技术，实现查询数据库，并将结果输出到控制台。
public class JDBC基础创建过程 {
	@Test
	public void test1() throws Exception {
		//注册驱动		驱动注册两边不好用,运用反射。
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		
		//创建连接 connection
		//jdbc:数据库类型，ip地址+端口号+数据库名，如果去掉localhost:3306，就是默认本机访问
		//能用接口就不用类，
		//常用就是这第一中
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		
		//得到执行sql语句的statement对象
		Statement stmt = conn.createStatement(); 
		//执行sql
		ResultSet rs =stmt.executeQuery("select * from users");
		//处理结果
		while(rs.next( )){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------");
		}
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}
	@Test
	public void test() throws Exception{
				Class.forName("com.mysql.jdbc.Driver");
				
				//第二种建立数据库连接的方法
				Properties info = new Properties();
				info.setProperty("user", "root");
				info.setProperty("password", "abc");
				Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06",info );
				
				Statement stmt = conn.createStatement(); 
				ResultSet rs =stmt.executeQuery("select * from users");
				while(rs.next( )){
					System.out.println(rs.getObject(1));
					System.out.println(rs.getObject(2));
					System.out.println(rs.getObject(3));
					System.out.println(rs.getObject(4));
					System.out.println(rs.getObject(5));
					System.out.println("-----------");
				}
				rs.close();
				stmt.close();
				conn.close();
		
	}
	
	@Test
	public void test2() throws Exception{
				Class.forName("com.mysql.jdbc.Driver");
				
				//第三种建立数据库连接的方法
				
				Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
				
				Statement stmt = conn.createStatement(); 
				ResultSet rs =stmt.executeQuery("select * from users");
				while(rs.next( )){
					System.out.println(rs.getObject(1));
					System.out.println(rs.getObject(2));
					System.out.println(rs.getObject(3));
					System.out.println(rs.getObject(4));
					System.out.println(rs.getObject(5));
					System.out.println("-----------");
				}
				rs.close();
				stmt.close();
				conn.close();
			
		
	}
}
