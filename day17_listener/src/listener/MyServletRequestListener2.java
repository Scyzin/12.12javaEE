package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestListener2 implements
		ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("���������");
		
		
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("�Ƴ���������");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		//srae�����¼�Դ����
		// TODO Auto-generated method stub
		System.out.println(srae.getName()+"\t" +srae.getValue());
		System.out.println("�滻��������");
		
	}

}
