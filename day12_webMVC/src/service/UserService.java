package service;

import doMain.User;

public interface UserService {
	/**
	 * 注册用户信息
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息	
	 * @param user
	 * @return
	 */
	public User login (User user);
}
