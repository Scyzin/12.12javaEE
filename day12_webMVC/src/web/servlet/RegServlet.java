package web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import service.UserService;
import service.impl.UserServiceImpl;
import doMain.User;

public class RegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取表单数据
		User user = new User();
		try {
			/*ConvertUtils.register(new Converter() {//注册一个日期转换器

				public Object convert(Class type, Object value) {
					// TODO Auto-generated method stub
					Date date1 = null;
					if (value instanceof String) {
						String date = (String) value;
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						
						try {
							date1 = sdf.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return date1;
				}
			}, Date.class);*/
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());

			// 调用业务逻辑
			UserService us = new UserServiceImpl();
			us.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 分发转向
		response.getWriter().write("注册成功！1秒中跳转到主页");
		response.setHeader("refresh", "1;url=" + request.getContextPath()
				+ "/index.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
