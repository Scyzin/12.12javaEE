package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("servletRequest������");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("servletRequest������");
	}

}
