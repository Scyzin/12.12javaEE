package a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	@Test
	public void demo01(){
		//֮ǰ����
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}
	@Test
	public void demo02(){
		//��spring������ʹ��
		//1�������
		String xmlPath="a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//�������--����Ҫ�Լ�new�����������л��
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}
}
