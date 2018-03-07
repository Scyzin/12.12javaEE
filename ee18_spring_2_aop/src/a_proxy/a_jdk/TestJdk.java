package a_proxy.a_jdk;

import org.junit.Test;

public class TestJdk {
	@Test
	public void demo1() {
		UserService userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();

	}
}
