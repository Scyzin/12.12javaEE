package pool;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

import util.DBUtils;

//模拟数据库连接池，不具备实际开发意义
public class SimpleConnectionPool {
	// 创建一个存放连接的池子
	private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections
			.synchronizedList(new LinkedList<Connection>());
	static {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError("初始化数据库连接失败，请检查配置文件是否正确！");
		}
	}
	//得到一个连接
	public Connection getConnectionFromPool(){
		Connection conn = null;
		if(pool.size()>0){
			conn = pool.removeFirst();//从池中取出一个连接
			return conn;
		}else{
			//等待
			//新创建一个连接
			throw new RuntimeException("服务器繁忙");
		}
		
	}
	//释放连接
	public void release(Connection conn){
		pool.addLast(conn);
		
	}
}
