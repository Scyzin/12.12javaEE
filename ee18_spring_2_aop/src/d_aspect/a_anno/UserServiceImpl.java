package d_aspect.a_anno;

import org.springframework.stereotype.Service;

@Service("userServiceId")
public class UserServiceImpl implements UserService {

	public void addUser() {
		System.out.println("d_aspect.a_xml add user");
	}

	public void updateUser() {
		System.out.println("d_aspect.a_xml update user");
	}

	public void deleteUser() {
		System.out.println("d_aspect.a_xml delete user");
	}

}
