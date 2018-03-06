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
		//��spring������ʹ��
		//1�������
		String xmlPath="b_di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//�������--����Ҫ�Լ�new�����������л��
		BookService bookService = (BookService) applicationContext.getBean("bookServiceId");		
		
		bookService.addBook();
	}
	
	@Test
	public void demo02(){
		//ʹ��BeanFactory  --��һ������getBeanʵ����
		String xmlPath = "com/itheima/b_di/beans.xml";
		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		
		BookService bookService = (BookService) beanFactory.getBean("bookServiceId");
		
		bookService.addBook();
		
	}

}
