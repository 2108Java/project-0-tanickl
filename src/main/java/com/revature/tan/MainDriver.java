package com.revature.tan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.revature.tan.*;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;


public class MainDriver {


	public static void main(String[] args) {
	

	Displays go = new DisplaysImpl();
	go.displayStart();


	}
}
