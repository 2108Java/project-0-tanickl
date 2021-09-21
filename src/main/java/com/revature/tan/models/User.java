package com.revature.tan.models;


import java.util.List;

import org.apache.logging.log4j.core.util.SystemClock;

public abstract class User {

	
	//FIELDS // these correspond to columns in users table in database
	protected int userId;
	protected String userName;
	protected String userPass;
//	private String firstName; //will implement if I get around to it
//	private String lastName;
	
	
	//DEFAULT CONSTRUCTOR
	public User() {
		super();
	}
	
	
	//CONSTRUCTOR
	public User(int userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}


	
	//GETTERS & SETTERS
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	
}