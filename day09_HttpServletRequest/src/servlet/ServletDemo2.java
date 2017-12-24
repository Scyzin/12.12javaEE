package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1(request);
		//test2(request);
		//������Ϣͷ
		Enumeration headers = request.getHeaders("accept-language");
		while(headers.hasMoreElements()){
			String e = (String) headers.nextElement();
			System.out.println(e+":"+request.getHeader(e));
		}
	}

	private void test2(HttpServletRequest request) {
		Enumeration names = request.getHeaderNames();
		while(names.hasMoreElements()){
			String e = (String)names.nextElement();
			System.out.println(e+":" +request.getHeader(e));
		}
	}

	private void test1(HttpServletRequest request) {
		//���������Ϣͷ����Ϣ
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		if(header.toLowerCase().contains("msie")){
			System.out.println("��ʹ�õ���IE�����");
		}else if(header.toLowerCase().contains("firefox")){
			System.out.println("��ʹ�õ��ǻ�������");
		}else if(header.toLowerCase().contains("chrome")){
			System.out.println("��ʹ�õ��ǹȸ������");
		}else{
			System.out.println("��ʹ�õ������������");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
