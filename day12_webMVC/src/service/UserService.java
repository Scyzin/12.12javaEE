package service;

import doMain.User;

public interface UserService {
	/**
	 * ע���û���Ϣ
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * �����û�������������û���Ϣ	
	 * @param user
	 * @return
	 */
	public User login (User user);
}
