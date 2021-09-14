package com.revature.tan.service;

public interface Authentication {

	public boolean validate(String username); //check if user exists
		
	public boolean authenticate(String username, String password); //verify that they are the user




	
	
	
//end of interface
}


/////////////////////////////////////
//	must be able to
//		verify employee
//		verify customer
//			same class, maybe public abstract User?
//		
//		will need to reference a db that has
//				username unique not null
//				user_type, primary key (unique, serial), password, name				
/////////////////////////////////////