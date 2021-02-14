package model;

import java.util.List;
import java.util.ArrayList;

public class Classroom {
	
	private List<UserAccount> userList;
	
	public Classroom() {
		userList = new ArrayList<>();
	}
	
	public void addUserAccount(String name,String password, String gender, String career, String birthday, String favBrowser) {
		userList.add(new UserAccount(name, password, gender, career, birthday, favBrowser));
	}
	
	public List<UserAccount> getUserList() {
		return userList;
	}
}