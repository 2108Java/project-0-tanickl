package com.revature.tan.models;

import com.revature.tan.service.Authentication;

public class Employee extends User implements Authentication {

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(User a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean authenticate(User a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEmployee(boolean isEmployee) {
		// TODO Auto-generated method stub

	}

}
