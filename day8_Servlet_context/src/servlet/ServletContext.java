package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContext extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ͨ������generic�ķ������õ�ĳ������
		javax.servlet.ServletContext application = this.getServletContext();
		//ͨ��������Ӽ�ֵ�ԡ�
		application.setAttribute("name", "tom");
		System.out.println(application.getClass().getName());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
