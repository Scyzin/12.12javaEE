package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//��ʵ����
public class ServletDemo implements Servlet{
	//servlet�������ڵķ���
	//��һ������ʱ����
	//ʵ����
	public ServletDemo(){
		System.out.println("ʵ�����ɹ�");
	}
	//servlet�������ڵķ���
	//��һ������ʱ����
	//��ʼ��
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ���ɹ�");
	}
	//servlet�������ڵķ���
	//����
	//ÿ�η��ʶ�����õ�
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("hello,servlet");
	}
	//servlet�������ڵķ���
	//Ӧ��ж�أ����߷������رվ�����
	//����
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy������");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
