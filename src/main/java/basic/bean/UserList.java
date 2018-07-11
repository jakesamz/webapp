package basic.bean;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	
	public static List<User> get() {
		int size = 10;
		List<User> list = new ArrayList<User>(size);
		for (int i = 0; i < size; i++) {
			User user = new User();
			user.setId(String.valueOf(100000 + i));
			user.setName("name_" + i);
			list.add(user);
		}
		return list;
	}
	
}
