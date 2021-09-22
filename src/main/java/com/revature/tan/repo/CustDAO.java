package com.revature.tan.repo;

import com.revature.tan.models.Account;

public interface CustDAO {

	public void mkAccount();
	public void viewAccounts();
	public void viewTransactions();
	public void mkDeposit(); 
	public void mkWithdraw();
	public void mkTransfer();
	public void mkTransferOut();
	void mkAccount(Account a);
}
