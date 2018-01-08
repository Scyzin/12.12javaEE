package timer;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		//�õ�application�����е�list����
		ServletContext application = session.getServletContext();
		//�õ�session���󣬲�����list������
		List<HttpSession> list = (List<HttpSession>)application.getAttribute("sessions");
		
		list.add(session);
		System.out.println("�����" + session.getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
