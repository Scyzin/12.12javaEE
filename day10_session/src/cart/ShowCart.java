package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Book;

public class ShowCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("���ﳵ��������Ʒ��<br/>");
		 HttpSession session = request.getSession();
		//�õ�session����
		List<Book> books = (List<Book>)session.getAttribute("cart");
		if(books==null){
			out.print("�㻹ʲô��û����");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/show");
			//response.sendRedirect(request.getContextPath()+"/servlet/show");
			return;
		}
		for (Book book : books) {
			out.write(book.getName()+"<br/>");
			
		}
		//��¼�û������洢��Ϣ�Ǵ����session��
		//sessionĬ����30���ӡ�
		//����session�Ĵ��ʱ��
		//session.setMaxInactiveInterval(10);
		//invalidate() ʹ�Ự��Ч���˳���ʱ��Ū�ġ�
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
