package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterConfigTest implements Filter {

	private FilterConfig filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//ͨ��filter Config�����ȡ�������ļ��еĳ�ʼ����Ϣ
		String value =filterConfig.getInitParameter("encoding");
		System.out.println(value);
		request.setCharacterEncoding(value);
		
		//����
		chain.doFilter(request, response);
		
	}

	public void destroy() {
		
	}

}
