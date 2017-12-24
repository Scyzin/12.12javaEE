package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String str = "aaaaa";
		//���Ǳ���������ӵ�request������
		request.setAttribute("s", str);
		System.out.println("A:�������");
		System.out.println("B:�Ұ첻�ˣ����ҿ������˰����");
		//������ת����demo6��
		request.getRequestDispatcher("/servlet/servletDemo6").forward(request, response);
		//ע������ת��������ת������Ӧ��
		//request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
		//ʹ���ض���
		//response.sendRedirect(request.getContextPath()+"/servlet/servletDemo6");
		//������ת������Ӧ��
		//response.sendRedirect("http://www.baidu.com");
		System.out.println("B:�°�����");
		
		//�������
		request.getRequestDispatcher("/servlet/servletDemo6").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
