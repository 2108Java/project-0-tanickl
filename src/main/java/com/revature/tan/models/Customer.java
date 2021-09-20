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

	
	
	
	
	//FROM DISPLAYIMPL
	
	public void mkAccount() {
		// TODO Auto-generated method stub
		
	}


	public void viewAccounts() {
		// TODO Auto-generated method stub
		
	}


	public void viewTransactions() {
		// TODO Auto-generated method stub
		
	}


	public void mkDeposit() {
		// TODO Auto-generated method stub
		
	}


	public void mkWithdraw() {
		// TODO Auto-generated method stub
		
	}


	public void mkTransfer() {
		// TODO Auto-generated method stub
		
	}


	public void mkTransferOut() {
		// TODO Auto-generated method stub
		
	}


	public void mkJoint() {
		// TODO Auto-generated method stub
		
	}
	
}
