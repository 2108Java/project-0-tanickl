package com.revature.tan.service;

import com.revature.tan.models.User;

public interface Authenticate {

	public boolean validUser(String userName);
	
	public boolean authenticUser(String userPass);

	
//end of interface
}
