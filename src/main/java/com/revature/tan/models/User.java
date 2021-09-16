package com.revature.tan.models;

public abstract class User {

	//fields
	private String userId;
	private String userName;
	private String firstName;
	private String lastName;
	private boolean isEmployee;
	
	
	//setters & getters
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
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



	public abstract boolean isEmployee() {
		return isEmployee;
	}



	public abstract void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	
	
	//constructors
	public User() {
		// TODO Auto-generated constructor stub
	}
//end of abstract class
}
//

