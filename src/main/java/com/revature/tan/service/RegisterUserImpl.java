package com.revature.tan.service;

import java.util.Scanner;

import com.revature.tan.models.User;


public class RegisterUserImpl implements RegisterUser {


	public RegisterUserImpl() {
	
	}

	@Override
	public boolean checkUsername(String a) {
	
		return false;
	}

	
	@Override
	public User registerUsername(String d) {
		return null;
		
	}
	
	@Override
	public boolean checkPassMatch(String b, String c) {

		return false;
	}
	

	@Override
	public User registerPassword(User u, String pass) {
		return u;
	}

	

}
