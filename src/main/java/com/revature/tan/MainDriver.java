package com.revature.tan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;

import com.revature.tan.*;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;
import com.revature.tan.repo.*;
import com.revature.tan.models.*;
import com.revature.tan.service.*;
import com.revature.tan.service.ConnectionMaker;

public class MainDriver {

	
	public static void main(String[] args) {
	
//		bankLog.info("starting the application");
//		final org.apache.logging.log4j.Logger BANKLOG = LogManager.getLogger();
//			then throughout, MainDriver.bankLog.info("custom message");
		
		
	Displays go = new DisplaysImpl();
	
	
	go.displayStart();

 

	}
}
