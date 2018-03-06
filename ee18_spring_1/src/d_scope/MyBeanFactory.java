package d_scope;

/**
 *实例工厂
 *
 */
public class MyBeanFactory {
	
	/**
	 *创建实例
	 * @return
	 */
	public UserService createService(){
		return new UserServiceImpl();
	}

}
