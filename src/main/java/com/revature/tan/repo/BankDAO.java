package com.revature.tan.repo;

public interface BankDAO {

	
	public void applyForNewAcct();
		//or should I use boolean to check if successful?
	
	public boolean checkUserLogin();
		//I think I can just query the DAO whether user&pass match and return true
		//same method for employee & customer users
	
	public List<Account> getMyAccounts();
		//use a generic to make handling multiple accounts easier
		//I think it will be simpler to have separate methods for employee & customer
	
	public boolean makeDeposit();
		//boolean will check whether successful
	
	public boolean makeWithdrawal();
		//same as above
	
	//public boolean addJointUser();
		//this was a stretch goal, so omit for now
	
	public boolean approvePendingAccount();
		//employee approve
	
	public boolean approveAllPending();
	
	public List<Account> viewTransactionLog();
	
//end of interface
}	
//

	
