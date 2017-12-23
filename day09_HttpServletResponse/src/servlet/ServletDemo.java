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
		//服务器默认的编码为ISO-9959-1，不支持中文。
		/*//UTF-8解析文本
		response.setCharacterEncoding("UTF-8");
		//告诉客户端用什么编码？   用消息头
		response.setHeader("content-type", "text/html;charset=UTF-8");*/
		
		//一个命令告诉服务器应用UTF-8解析文本，告诉客户端要使用什么文本
		response.setContentType("text/html;UTF-8");
		
		PrintWriter out = response.getWriter();//得到一个字符输出流
		out.write("你好！");//向客户端相应文本内容
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
