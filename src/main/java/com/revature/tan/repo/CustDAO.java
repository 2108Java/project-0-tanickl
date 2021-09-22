package com.revature.tan.repo;

import com.revature.tan.models.Account;
import com.revature.tan.models.User;

public interface CustDAO {

	public String viewAccounts(Account a);
	public void viewTransactions();
	public void mkDeposit(Account a, double y); 
	public User mkWithdraw(Account a, double y);
	public void mkTransfer();
	public void mkTransferOut();
	void mkAccount(Account a);
}
