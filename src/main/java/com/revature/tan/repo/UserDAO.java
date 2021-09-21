package com.revature.tan.repo;

import com.revature.tan.models.User;

public interface UserDAO {

	public User selectUserByUserName(String username);

	public boolean selectUniqueUserName(String a);

	public User insertNewUserName(String d);

	public User insertNewUserPass(String pass);

	public User insertNewUser(String username, String pass);

}