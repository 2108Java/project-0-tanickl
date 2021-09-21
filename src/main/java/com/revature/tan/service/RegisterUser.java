package com.revature.tan.service;

import com.revature.tan.models.User;

public interface RegisterUser {

	public boolean checkUsername(String a);

	public User registerUsername(String username);

	public User registerPassword(String pass);

	public void registerNewUser(String username, String pass);
	
}
