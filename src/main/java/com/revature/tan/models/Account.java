package com.revature.tan.models;

public class Account {

	//FIELDS
	
	private int pkAcct;
	private boolean isApproved;
	private double balance;
	private String acctType;
	private int userForKey;
	

	//NO-ARG CONSTRUCTOR, includes test values for fields
	public Account() {
		this.pkAcct = -1;
		this.isApproved = false;
		this.balance = 0.00;
		this.userForKey = -1;
	}
	
	
	//CONSTRUCTORS
	
	public Account(User u) {
		this.userForKey = u.getUserId();
	}
	
	
	public Account(int userForKey) {
		super();
		
		this.userForKey = userForKey;
	}
	
	
	//CONSTRUCTOR, all fields explicit
	public Account(int pkAcct, boolean isApproved, double balance, String acctType, int userForKey) {
		super();
		this.pkAcct = pkAcct;
		this.isApproved = isApproved;
		this.balance = balance;
		this.acctType = acctType;
		this.userForKey = userForKey;
	}



	
	//GETTERS & SETTERS
	public int getPkAcct() {
		return pkAcct;
	}


	public void setPkAcct(int pkAcct) {
		this.pkAcct = pkAcct;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getAcctType() {
		return acctType;
	}


	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}


	public int getUserForKey() {
		return userForKey;
	}


	public void setUserForKey(int userForKey) {
		this.userForKey = userForKey;
	}


	@Override
	public String toString() {
		return "Account [account number: " + pkAcct + ", is Approved = " + isApproved + ", balance = " + balance + ", acctType = "
				+ acctType + ", owner's user id = " + userForKey + "]";
	}	
		

}

	
	



