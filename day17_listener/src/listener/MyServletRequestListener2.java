package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestListener2 implements
		ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("添加了属性");
		
		
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("移除了了属性");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		//srae代表事件源对象
		// TODO Auto-generated method stub
		System.out.println(srae.getName()+"\t" +srae.getValue());
		System.out.println("替换了了属性");
		
	}

}
