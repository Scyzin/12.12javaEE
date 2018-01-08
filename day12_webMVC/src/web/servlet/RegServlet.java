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
		// ��ȡ��������
		User user = new User();
		try {
			/*ConvertUtils.register(new Converter() {//ע��һ������ת����

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

			// ����ҵ���߼�
			UserService us = new UserServiceImpl();
			us.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �ַ�ת��
		response.getWriter().write("ע��ɹ���1������ת����ҳ");
		response.setHeader("refresh", "1;url=" + request.getContextPath()
				+ "/index.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}