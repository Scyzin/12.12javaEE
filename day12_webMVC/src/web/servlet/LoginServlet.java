package web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.UserService;
import service.impl.UserServiceImpl;

import doMain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		
			try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			UserService us = new UserServiceImpl();
			
			User u;
			try {
				u = us.login(user);
			
				//�ַ�ת��
				if(u!=null){
					request.getSession().setAttribute("u", user);//�����¼�ɹ����Ͱ�user����ŵ�session���� ��
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}else{
					
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
