package com.revature.tan.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMaker implements Connection {
	
	//FIELDS
	// Consider changing to AWS
	//private	static final String URL = "jdbc:postgresql://localhost:5432/";
	private	static final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
	private static final String USERNAME= "postgres";
	private static final String PASSWORD = "49STOREdata40$16";
	
	
	//CONSTRUCTOR
	public ConnectionMaker() {
//		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
//		final String USERNAME= "postgres";
//		final String PASSWORD = "49STOREdata40$16";
	}
	
	
	//METHODS
	public static Connection getConnection() { 
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			return connection;
		}catch(SQLException e){
			System.out.println("Unable to connect to database!");
			e.printStackTrace();
			return null;
		}
	} 
	
	
}
