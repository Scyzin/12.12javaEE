package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ͨ��·���õ�һ��������
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/��Ů.jpg");
		FileInputStream fis = new FileInputStream(path);
		//�����ֽ������
		ServletOutputStream sos = response.getOutputStream();
		
		//�õ�Ҫ���ص��ļ���
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		//�����ļ����ı���
		filename = URLEncoder.encode(filename, "UTF-8");//������ȫ���ļ�����ΪUTF-8��ʽ
		
		//��֪�ͻ���Ҫ�����ļ�
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setHeader("content-type", "image/jpeg");
		
		//ִ���������
		int len = 1;
		byte[] b = new byte[1024];
		while((len=fis.read(b))!=-1){
			sos.write(b,0,len);
		}
		
		sos.close();
		fis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
