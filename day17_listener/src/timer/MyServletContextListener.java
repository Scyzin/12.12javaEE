package timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//通过事件源对象得到事件源
		ServletContext application = sce.getServletContext();
		//创建一个集合用于存储所有session对象
		final List<HttpSession> list = Collections.synchronizedList(new ArrayList<HttpSession>());
		//会出现并发异常，所以加锁
		
		//把集合放到application域中
		application.setAttribute("sessions", list);
		
		//创建一个计时器对象
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("开始扫描了");
				for(Iterator iterator = list.iterator();iterator.hasNext();){
					HttpSession session = (HttpSession) iterator.next();
					long l =System.currentTimeMillis() - session.getLastAccessedTime();
					if(l >5000){//如果时间大于5秒，把session销毁
						System.out.println("session移除了" +session.getId());
						session.invalidate();//把session销毁
						//list.remove(session);//从集合中移除
						iterator.remove();
						
					}
				}
				//下面这个循环无法动态改写
				/*for (HttpSession session : list) {
				long l = System.currentTimeMillis()-session.getLastAccessedTime();
				if(l>5000){//如果时间大于5秒，把session销毁
					session.invalidate();//把session销毁
					list.remove(session);//从集合中移除
				}
			}*/
			}
		}, 2000, 5000);//延迟2s后执行，每间隔5s执行一次
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
