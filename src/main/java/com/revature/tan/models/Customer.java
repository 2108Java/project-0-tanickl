package com.revature.tan.models;

import java.util.List;

public class Customer extends User {

	//FIELDS
	private List<Account> accountSummary;
	private List<Transactions> actionSummary; //keep?
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int userId, String userName, String userPass, String firstName, String lastName) {
		super(userId, userName, userPass, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public List<Account> getAccountSummary() {
		return accountSummary;
	}

	public void setAccountSummary(List<Account> accountSummary) {
		this.accountSummary = accountSummary;
	}

	public List<Transactions> getActionSummary() {
		return actionSummary;
	}

	public void setActionSummary(List<Transactions> actionSummary) {
		this.actionSummary = actionSummary;
	}

	
	
}
