package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

//ʹ��jdbc������ʵ�ֲ�ѯ���ݿ⣬����������������̨��
public class JDBC������������ {
	@Test
	public void test1() throws Exception {
		//ע������		����ע�����߲�����,���÷��䡣
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		
		//�������� connection
		//jdbc:���ݿ����ͣ�ip��ַ+�˿ں�+���ݿ��������ȥ��localhost:3306������Ĭ�ϱ�������
		//���ýӿھͲ����࣬
		//���þ������һ��
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		
		//�õ�ִ��sql����statement����
		Statement stmt = conn.createStatement(); 
		//ִ��sql
		ResultSet rs =stmt.executeQuery("select * from users");
		//������
		while(rs.next( )){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------");
		}
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	@Test
	public void test() throws Exception{
				Class.forName("com.mysql.jdbc.Driver");
				
				//�ڶ��ֽ������ݿ����ӵķ���
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
				
				//�����ֽ������ݿ����ӵķ���
				
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
