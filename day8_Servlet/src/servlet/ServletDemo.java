package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//单实例，
public class ServletDemo implements Servlet{
	//servlet生命周期的方法
	//第一被访问时调用
	//实例化
	public ServletDemo(){
		System.out.println("实例化成功");
	}
	//servlet生命周期的方法
	//第一被访问时调用
	//初始化
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化成功");
	}
	//servlet生命周期的方法
	//服务
	//每次访问都会调用的
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("hello,servlet");
	}
	//servlet生命周期的方法
	//应用卸载，或者服务器关闭就销毁
	//销毁
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy销毁了");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
