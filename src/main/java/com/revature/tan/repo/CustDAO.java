package com.revature.tan.repo;

import com.revature.tan.models.Account;
import com.revature.tan.models.User;

public interface CustDAO {

	
	public void viewTransactions(User u);
	public User mkDeposit(Account a, double y); 
	public void mkWithdraw(Account a, double y);
	public void mkTransfer(int debit, int credit, double amt);
	public void mkTransferOut(int tdebit, String trUser, double amt2);
	public void mkAccount(Account a);
	public User viewAccounts(User u);
	
}
