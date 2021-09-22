package com.revature.tan.presentation;

import com.revature.tan.models.User;
import com.revature.tan.*;

public interface Displays {

	public void displayStart();
		
	
	public User displayLogin();


	public void displayRegisterNewUser();


	public void displayNewUser();


	public User displayCust(User u);


	User displayEmpMenu(User u);


}
