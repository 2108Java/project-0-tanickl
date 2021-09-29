package com.revature.tan.repo;

public interface EmpDAO {

	public void viewAll();
	public void viewByName(String cust);
	public void approvePending(int cust3);
	public void viewLog();
	public void selectPending();
	public void rejectPending(int cust4);
	public void viewCustRoll();
	
}
