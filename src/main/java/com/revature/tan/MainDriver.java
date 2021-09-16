package com.revature.tan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.tan.presentation.ConsoleSession;

public class MainDriver {


	//BEN DEMOS JDBC in MAINDRIVER
	user, password, endpointURL
	
	public static String username = "java_login";
	public static String password = "pass";
	public static String url = "jdbc:postgresql://database-1.cqosei ..." //grab from AWS 
			// Dbeaver abstracts some details from Server/host name
			//check "edit Driver "postgresql" in Dbeaver
	
	public static void main(String[] args) {
		try {
		Connection conn = DriverManager.getConnection(url, username, password);
			//JDBC
				//java dbase connectivity
				//an api to abstract away details of dbase connection
				//an interface
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//the problem with the above code as written is 
		//that it doesn't separate the application into layers
		//and this MainDriver handles too much complexity
		//for a team to edit or maintain it effectively
		//There is no way to unit test and identify specific problems
		
		//all the above should be abstracted and replaced with a single line
		//that invokes a DAO method
		ps.execute(); //handy if you don't need a full result set back from query
		//END BEN DEMO, cf video.09.16.1315.
		
		ConsoleSession go = new ConsoleSession();

		go.startDisplay();
	}

}
