package com.revature.tan.models;


import java.util.List;

import org.apache.logging.log4j.core.util.SystemClock;

public abstract class User {

	
	//FIELDS // these correspond to columns in users table in database
	private int userId;
	private String userName;
	private String userPass;
	private String firstName;
	private String lastName;
	
	
	//DEFAULT CONSTRUCTOR
	public User() {
		super();
	}
	
	
	//CONSTRUCTOR
	public User(int userId, String userName, String userPass, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.firstName = firstName;
		this.lastName = lastName;
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


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	
}