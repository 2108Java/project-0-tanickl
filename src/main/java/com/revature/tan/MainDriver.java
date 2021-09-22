package com.revature.tan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.revature.tan.*;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;
import com.revature.tan.repo.*;
import com.revature.tan.models.*;



public class MainDriver {


	public static void main(String[] args) {
	

//	Displays go = new DisplaysImpl();
//	go.displayLogin();

 
		Employee e = new Employee();
		e.viewAll();
	}
}
