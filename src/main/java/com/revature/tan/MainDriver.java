package com.revature.tan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.revature.tan.*;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;
import com.revature.tan.repo.*;
import com.revature.tan.models.*;
import com.revature.tan.service.*;
import com.revature.tan.service.ConnectionMaker;

public class MainDriver {

	public static void main(String[] args) {
	
//		final Connection connection = ConnectionMaker.getConnection();
	//JDBC troubleshoot
	
	//1
	// Consider changing to AWS
	//private	static final String URL = "jdbc:postgresql://localhost:5432/";
//	final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
//	final String USERNAME= "postgres";
//	final String PASSWORD = "49STOREdata40$16";
	
	
//	public Connection connection = ConnectionMaker.getConnection(); //to try as static method
//	final ConnectionMaker connectionMaker = new ConnectionMaker(); //instantiating alone
//	Connection connection = connectionMaker.getConnection();		//might need to switch off static then			
//	connectionMaker.getConnection(); //try it alone
	

	
	
//	User u = new User("tester", "passpass", true); // no user here; construct in displayImpl
	
		
		
	Displays go = new DisplaysImpl();
	
	
	go.displayStart();

 

	}
}
