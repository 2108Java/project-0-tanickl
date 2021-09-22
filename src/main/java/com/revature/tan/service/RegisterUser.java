package com.revature.tan.service;

import com.revature.tan.models.User;

public interface RegisterUser {

	public boolean checkUsername(String a);

	public void registerNewUser(String username, String pass, boolean b);
	
}
