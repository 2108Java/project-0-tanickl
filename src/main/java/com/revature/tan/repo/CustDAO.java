package com.revature.tan.repo;

import com.revature.tan.models.Account;
import com.revature.tan.models.User;

public interface CustDAO {

	public User mkAccount(Account a, User u);
	public User viewAccounts(User u);
	public User mkDeposit(User u);
	public void viewTransactions(User u);
	public User mkWithdraw(User u);
	public User mkTransfer(User u);
	public User mkTransferOut(User u);

	
}
