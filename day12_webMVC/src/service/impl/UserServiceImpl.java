package service.impl;

import service.UserService;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import doMain.User;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	public void register(User user) throws Exception {
		userDao.addUser(user);
		
	}

	public User login(User user) {
		User u = null;
		try {
			u =userDao.findUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return u;
	}

}
