package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������
		/*getMethod(); �������ʽ
		***getRequestURL();���ؿͻ��˷�������ʱ������URL��
		***getRequestURI(); �����������е���Դ�����֡�
		*****getContextPath(); ��ǰӦ�õ�����Ŀ¼ /day09_01_request
		getQueryString() ; �����������еĲ������֡�*/
		System.out.println(request.getMethod());//get
		System.out.println(request.getRequestURL());//http://localhost:8080/day09_HttpServletRequest/servlet/servletDemo1
		System.out.println(request.getRequestURI());// /day09_HttpServletRequest/servlet/servletDemo1
		System.out.println(request.getContextPath());// /day09_HttpServletRequest
		System.out.println(request.getQueryString());// null
		System.out.println(request.getClass().getName());//org.apache.catalina.connector.RequestFacade

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
