package com.revature.tan.service;

import com.revature.tan.models.User;

public interface Authentication {

	public boolean validate(User a); //check if user exists
		
	public boolean authenticate(User a); //verify that they are the user


	

	
	
	
//end of interface
}
