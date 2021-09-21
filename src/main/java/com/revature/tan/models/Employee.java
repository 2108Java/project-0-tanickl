package com.revature.tan.models;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import com.revature.tan.*;
import com.revature.tan.repo.EmpDAO;


public class Employee extends User implements EmpDAO {

	//NO ADDITIONAL FIELDS NECESSARY
	
	
	//CONSTRUCTORS
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int userId, String userName, String userPass, String firstName, String lastName) {
		super(userId, userName, userPass, firstName, lastName);
	}

	
	//METHODS from EmpDAO
	@Override
	public void viewAll() { // SELECT from ACCOUNTS
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewByName() { //SELECT from ACCOUNTS where
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approvePending() { //UPDATE 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewLog() { //SELECT 
		// TODO Auto-generated method stub
		
	}


	//OTHER METHODS
	
	
}
