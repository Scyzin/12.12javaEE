package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ȡ������
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		//��session�л�ȡ��֤��
		String scode = (String) request.getSession().getAttribute("scode");
		//����ҵ���߼�
		if("tom".equals(userName)&&"123".equals(pwd)){
			//�ַ�ת��
			if(!code.equalsIgnoreCase(scode)){
				request.setAttribute("msg", "��֤�����");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			out.print("��¼�ɹ���");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
