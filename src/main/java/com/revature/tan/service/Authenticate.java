package com.revature.tan.service;

import com.revature.tan.models.User;

public interface Authenticate {


	public User getUser(String username);

	public boolean validUser(String userName);

	public boolean validUserAndPass(String userName, String userPass);

	
}
