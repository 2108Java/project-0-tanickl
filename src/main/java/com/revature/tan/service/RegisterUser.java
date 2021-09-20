package com.revature.tan.service;

import com.revature.tan.models.User;

public interface RegisterUser {

	public boolean checkUsername(String a);
	
	public boolean checkPassMatch(String b, String c);

	public void registerUsername(String username);

	public void registerPassword(String pass);
	
}
