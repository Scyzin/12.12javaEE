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
		out.print("购物车有以下商品：<br/>");
		 HttpSession session = request.getSession();
		//得到session对象
		List<Book> books = (List<Book>)session.getAttribute("cart");
		if(books==null){
			out.print("你还什么都没买呢");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/show");
			//response.sendRedirect(request.getContextPath()+"/servlet/show");
			return;
		}
		for (Book book : books) {
			out.write(book.getName()+"<br/>");
			
		}
		//登录用户名，存储信息是存放在session中
		//session默认是30分钟。
		//设置session的存活时间
		//session.setMaxInactiveInterval(10);
		//invalidate() 使会话无效，退出的时候弄的。
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
