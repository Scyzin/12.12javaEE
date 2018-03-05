package a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	@Test
	public void demo01(){
		//之前开发
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}
	@Test
	public void demo02(){
		//从spring容器中使用
		//1获得容器
		String xmlPath="a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//获得内容--不需要自己new，都从容器中获得
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}
}
