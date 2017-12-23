package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������Ĭ�ϵı���ΪISO-9959-1����֧�����ġ�
		/*//UTF-8�����ı�
		response.setCharacterEncoding("UTF-8");
		//���߿ͻ�����ʲô���룿   ����Ϣͷ
		response.setHeader("content-type", "text/html;charset=UTF-8");*/
		
		//һ��������߷�����Ӧ��UTF-8�����ı������߿ͻ���Ҫʹ��ʲô�ı�
		response.setContentType("text/html;UTF-8");
		
		PrintWriter out = response.getWriter();//�õ�һ���ַ������
		out.write("��ã�");//��ͻ�����Ӧ�ı�����
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
