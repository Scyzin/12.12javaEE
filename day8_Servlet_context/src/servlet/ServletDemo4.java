package servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// test1();
		// test2();
		test3();
	}

	// 获取/WEB-INF/classes/b.properties文件
	private void test3() throws IOException, FileNotFoundException {
		String path = this.getServletContext().getRealPath(
				"/WEB-INF/classes/servlet/c.properties");
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));

		System.out.println(pro.get("key"));
	}

	// 获取/WEB-INF/classes/b.properties文件
	private void test2() throws IOException, FileNotFoundException {
		String path = this.getServletContext().getRealPath(
				"/WEB-INF/classes/b.properties");
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));

		System.out.println(pro.get("key"));
	}

	private void test1() throws IOException, FileNotFoundException {
		String path = this.getServletContext().getRealPath(
				"/WEB-INF/a.properties");// 里面的参数以/开头
		// 创建一个Properties
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		System.out.println(pro.getProperty("key"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
