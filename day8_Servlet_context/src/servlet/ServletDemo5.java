package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("��Ҫ����");
		System.out.println("������Ұ첻�ˣ��ҿ��԰������˰�");
		javax.servlet.ServletContext application = this.getServletContext();
		/*RequestDispatcher rd = application.getRequestDispatcher("/servlet/demo6");
		rd.forward(request, response);*/
		//���������´���
		application.getRequestDispatcher("/servlet/demo6").forward(request, response);
		
		System.out.println("�°�����");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
