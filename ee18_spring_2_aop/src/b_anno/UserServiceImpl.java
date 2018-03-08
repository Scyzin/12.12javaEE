package b_anno;

import org.springframework.stereotype.Service;

@Service("userServiceId")
public class UserServiceImpl implements UserService {

	public void addUser() {
		System.out.println("d_aspect.b_anno addUser");
	}

	public String updateUser() {
		System.out.println("d_aspect.b_anno updateUser");
		int i = 1/ 0;
		return "阳志就是屌";
	}

	public void deleteUser() {
		
		System.out.println("d_aspect.b_anno deleteUser");
	}

}
