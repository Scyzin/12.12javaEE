package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet {

	
	/*private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}*/

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String encoding = config.getInitParameter("encoding");//��������ļ��е���Ϣ��
		System.out.println(encoding);*/
		//�ڶ��ַ�ʽ
		String encoding = this.getServletConfig().getInitParameter("encoding");
		System.out.println(encoding);
		//�����ַ�ʽ
		/*String encoding = super.getInitParameter("encoding");
		System.out.println(encoding);*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
