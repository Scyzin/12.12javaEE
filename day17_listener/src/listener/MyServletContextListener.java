package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements  ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("��ʼ�����");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}

}
