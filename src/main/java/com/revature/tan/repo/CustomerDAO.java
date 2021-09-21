package com.revature.tan.repo;


public interface CustomerDAO {

	public void mkAccount();
	public void viewAccounts();
	public void viewTransactions();
	public void mkDeposit(double x); 
	public void mkWithdraw(double x);
	public void mkTransfer(double x);
	public void mkTransferOut(double x);
	public void mkJoint();
}
