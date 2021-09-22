package com.revature.tan.repo;


public interface CustDAO {

	public void mkAccount();
	public void viewAccounts();
	public void viewTransactions();
	public void mkDeposit(); 
	public void mkWithdraw();
	public void mkTransfer();
	public void mkTransferOut();
}