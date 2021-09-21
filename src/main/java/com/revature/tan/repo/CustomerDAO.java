package com.revature.tan.repo;


public interface CustomerDAO {

	public void mkAccount();
	public void viewAccounts();
	public void viewTransactions();
	public void mkDeposit(); 
	public void mkWithdraw();
	public void mkTransfer();
	public void mkTransferOut();
	public void mkJoint();
}
