package com.revature.tan.service;

import com.revature.tan.models.User;

public interface Authenticate {


	public boolean validUser(String userName, String userPass);

	public User getUser(String username);

	
//end of interface
}
