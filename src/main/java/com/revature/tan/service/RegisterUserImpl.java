package com.revature.tan.service;

import java.util.Scanner;

import com.revature.tan.models.User;
import com.revature.tan.repo.UserDAO;


public class RegisterUserImpl implements RegisterUser {

	private UserDAO uDAO;
	
	//I think this is a layer that has to query DAO

	public RegisterUserImpl() {
	
	}

	
	
	@Override
	public boolean checkUsername(String a) { //SELECT from tables & check that username is unique
	
		return uDAO.selectUniqueUserName(a); //true if unique
	}

	
	
//	@Override
//	public User registerUsername(String d) { //INSERT into tables username
//		
//		return uDAO.insertNewUserName(d);
//	}
//	
//	
//	
//
//	@Override
//	public User registerPassword(String pass) { //INSERT into tables userPass
//		
//		return uDAO.insertNewUserPass(pass);
//	}



	@Override
	public void registerNewUser(String username, String pass) {
		uDAO.insertNewUser(username,pass);
		
	}


	

}
