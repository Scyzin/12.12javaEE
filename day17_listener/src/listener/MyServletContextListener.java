package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements  ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("初始化完成");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("被销毁了");
	}

}
