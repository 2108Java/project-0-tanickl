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

	public ConnectionMaker conn = new ConnectionMaker();

	public static void main(String[] args) {
	

	Displays go = new DisplaysImpl();
	go.displayStart();

 

	}
}
