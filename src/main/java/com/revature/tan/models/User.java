package com.revature.tan.models;


import java.util.List;

import org.apache.logging.log4j.core.util.SystemClock;

public class User {

	
	//FIELDS // these correspond to columns in users table in database
	private int userId;
	private String userName;
	private String userPass;
	private boolean isEmp;
	
	//DEFAULT CONSTRUCTOR
	public User() {
		super();
	}
	
	
	//CONSTRUCTOR
	public User(String userName, String userPass, boolean isEmp) {
		this.userName = userName;
		this.userPass = userPass;
		this.isEmp = isEmp;
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