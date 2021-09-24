package com.revature.tan.repo;

import com.revature.tan.models.Account;
import com.revature.tan.models.User;

public interface UserDAO {

	public User selectUserByUserName(String username);

	public boolean selectUniqueUserName(String a);

	public User insertNewUser(String username, String pass, boolean isEmp);

	public User selectUserById(Account a);

	public User getUser(String username);
	public User getUser(User u);
}
