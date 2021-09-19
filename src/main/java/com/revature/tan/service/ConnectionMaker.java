package com.revature.tan.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMaker {

	private static final String URL = "";
	private static final String USERNAME="";
	private static final String PASSWORD = "";
	
	public Connection getConnection() {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			return conn;
	}catch(SQLException e){
		//exception logic
	}
	} 
	
	public ConnectionMaker() {
		// TODO Auto-generated constructor stub
	}

}
