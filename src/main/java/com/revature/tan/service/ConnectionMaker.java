package com.revature.tan.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMaker {
	
	//FIELDS
	// Consider changing to AWS
	private static final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/postgres";
	private static final String USERNAME= "postgres";
	private static final String PASSWORD = "49STOREdata40$16";
	
	
	//CONSTRUCTOR
	public ConnectionMaker() {
		// TODO Auto-generated constructor stub
	}
	
	
	//METHODS
	public Connection getConnection() {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			return conn;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	} 
	
	


}
