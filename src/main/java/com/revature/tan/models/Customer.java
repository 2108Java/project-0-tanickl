package com.revature.tan.models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import com.revature.tan.*;
import com.revature.tan.repo.CustomerDAO;

public class Customer extends User implements CustomerDAO {

	//FIELDS //keep these? I can probably just SQL logic do the same
			//or maybe getObject();?
	private List<Account> accountSummary;
	private List<Transactions> actionSummary;
	
	//CONSTRUCTOR // Do I ever pass args to the Cust constructor?
	public Customer(int userId, String userName, String userPass) {
		userId = this.getUserId();
		userName = this.getUserName();
		userPass = this.getUserPass();
	}
	
	
	public Customer() {
		this.userId = this.getUserId();
		this.userName = this.getUserName();
		this.userPass = this.getUserPass();
	}

	
	//I might not need these, or if I do I might need something different in DAO
//	public List<Account> getAccountSummary() {
//		return accountSummary;
//	}
//
//	public void setAccountSummary(List<Account> accountSummary) {
//		this.accountSummary = accountSummary;
//	}
//
//	public List<Transactions> getActionSummary() {
//		return actionSummary;
//	}
//
//	public void setActionSummary(List<Transactions> actionSummary) {
//		this.actionSummary = actionSummary;
//	}

	
	
	
	
	//FROM DISPLAYIMPL
	
	@Override
	public void mkAccount() { //INSERT into table accounts ...
		
	}	
	
	


	public void viewAccounts() { //SELECT from accounts WHERE user ...
		// TODO Auto-generated method stub
		
	}


	public void viewTransactions() { //SELECT from table transactions WHERE ...
		// TODO Auto-generated method stub
		
	}


	public void mkDeposit() { 	//UPDATE table accounts ...
								//INSERT into tables transactions
		
	}


	public void mkWithdraw() { //UPDATE table accounts ...
								//INSERT into tables transactions
		
	}


	public void mkTransfer() { //UPDATE table accounts ...
								//INSERT into tables transactions
		
	}


	public void mkTransferOut() { //UPDATE table accounts
									//INSERT into tables transactions
		
	}


	public void mkJoint() { //INSERT INTO table JOINT ACCOUNTS 
		
	}
	
}
