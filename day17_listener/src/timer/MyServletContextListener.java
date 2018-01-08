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
		//ͨ���¼�Դ����õ��¼�Դ
		ServletContext application = sce.getServletContext();
		//����һ���������ڴ洢����session����
		final List<HttpSession> list = Collections.synchronizedList(new ArrayList<HttpSession>());
		//����ֲ����쳣�����Լ���
		
		//�Ѽ��Ϸŵ�application����
		application.setAttribute("sessions", list);
		
		//����һ����ʱ������
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("��ʼɨ����");
				for(Iterator iterator = list.iterator();iterator.hasNext();){
					HttpSession session = (HttpSession) iterator.next();
					long l =System.currentTimeMillis() - session.getLastAccessedTime();
					if(l >5000){//���ʱ�����5�룬��session����
						System.out.println("session�Ƴ���" +session.getId());
						session.invalidate();//��session����
						//list.remove(session);//�Ӽ������Ƴ�
						iterator.remove();
						
					}
				}
				//�������ѭ���޷���̬��д
				/*for (HttpSession session : list) {
				long l = System.currentTimeMillis()-session.getLastAccessedTime();
				if(l>5000){//���ʱ�����5�룬��session����
					session.invalidate();//��session����
					list.remove(session);//�Ӽ������Ƴ�
				}
			}*/
			}
		}, 2000, 5000);//�ӳ�2s��ִ�У�ÿ���5sִ��һ��
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
