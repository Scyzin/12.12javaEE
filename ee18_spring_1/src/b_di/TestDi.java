package b_di;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class TestDi {
	@Test
	public void demo01(){
		//从spring容器中使用
		//1获得容器
		String xmlPath="b_di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//获得内容--不需要自己new，都从容器中获得
		BookService bookService = (BookService) applicationContext.getBean("bookServiceId");		
		
		bookService.addBook();
	}
	
	@Test
	public void demo02(){
		//使用BeanFactory  --第一次条用getBean实例化
		String xmlPath = "com/itheima/b_di/beans.xml";
		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		
		BookService bookService = (BookService) beanFactory.getBean("bookServiceId");
		
		bookService.addBook();
		
	}

}
