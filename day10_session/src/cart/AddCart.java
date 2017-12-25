package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBUtil;
import entity.Book;

public class AddCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//����id�õ���
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		//�õ�session����
		 HttpSession session = request.getSession();
		//��session��ȡ��list�����ﳵ��
		List<Book> list = (List<Book>)session.getAttribute("cart");
		if(list==null){
			list = new ArrayList<Book>();
		}
		list.add(book);
		
		session.setAttribute("cart", list);//��list�Żص�session����
		
		out.print("����ɹ���");
		String url = request.getContextPath()+"/servlet/show";
		//response.setHeader("refresh", "2;url="+response.encodeURL(url));
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
