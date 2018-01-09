package download;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置一个要下载的文件
		String filename = this.getServletContext().getRealPath("销售榜单.csv");

		// 设置文件名的编码
		if (request.getHeader("user-agent").toLowerCase().contains("msie")) {
			filename = URLEncoder.encode(filename, "UTF-8");// 将不安全的文件名改为UTF-8格式
		} else {
			filename = new String(filename.getBytes("UTF-8"));
		}
		// 告知浏览器要下载文件
		response.setHeader("content-disposition", "attachment;filename="
				+ filename);
		// response.setHeader("content-type", "image/jpeg");
		response.setContentType(this.getServletContext().getMimeType(filename));// 根据文件名自动获得文件类型
		response.setCharacterEncoding("UTF-8");//告知服务器使用什么编码
		//创建一个文件输出流
		PrintWriter out = response.getWriter();
		
		out.write("电视机,20\n");
		out.write("洗衣机,10\n");
		out.write("冰箱,8\n");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
