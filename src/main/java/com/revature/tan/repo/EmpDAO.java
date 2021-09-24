package com.revature.tan.repo;

public interface EmpDAO {

	public void viewAll();
	public void viewByName(String custUserName);
	public void approvePending();
	public void viewLog();
	public void selectPending();
	public void rejectPending();
	
}
