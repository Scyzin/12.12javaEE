package pool;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

import util.DBUtils;

//ģ�����ݿ����ӳأ����߱�ʵ�ʿ�������
public class SimpleConnectionPool {
	// ����һ��������ӵĳ���
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
			throw new ExceptionInInitializerError("��ʼ�����ݿ�����ʧ�ܣ����������ļ��Ƿ���ȷ��");
		}
	}
	//�õ�һ������
	public Connection getConnectionFromPool(){
		Connection conn = null;
		if(pool.size()>0){
			conn = pool.removeFirst();//�ӳ���ȡ��һ������
			return conn;
		}else{
			//�ȴ�
			//�´���һ������
			throw new RuntimeException("��������æ");
		}
		
	}
	//�ͷ�����
	public void release(Connection conn){
		pool.addLast(conn);
		
	}
}
