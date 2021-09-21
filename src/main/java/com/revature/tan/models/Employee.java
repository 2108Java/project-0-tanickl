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
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.*;

public class Employee extends User implements EmpDAO {

	//NO ADDITIONAL FIELDS NECESSARY
	private ConnectionMaker conn; 
	
	//CONSTRUCTORS
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	
	//not using this constructor yet
//	public Employee(int userId, String userName, String userPass, String firstName, String lastName) {
//		super(userId, userName, userPass, firstName, lastName);
//	}

	
	
	//METHODS from EmpDAO
	@Override
	public void viewAll() { // SELECT from ACCOUNTS
		Connection connection = conn.getConnection();
		String sql = "SELECT * FROM accounts";
		PreparedStatement ps;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewByName(String custUserName) { //SELECT from ACCOUNTS where
		Connection connection = conn.getConnection();
		String sql = "SELECT * FROM accounts WHERE username = ?"; //finish
		PreparedStatement ps;
//		User u = null;
//		try {
//			ps = connection.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				u.setUserId(rs.getInt("user_id"));
//				u.setUserName(rs.getString("username"));
//				u.setUserPass(rs.getString("pword"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
		
		
	}

	@Override
	public void approvePending() { //UPDATE 
		Connection connection = conn.getConnection();
		String sql = "SELECT * accounts WHERE is_approved = false;"; //check this
		PreparedStatement ps;
		//then I want to print the ResultSet, and then give option to approve
		
		
	}

	@Override
	public void viewLog() { //SELECT 
		Connection connection = conn.getConnection();
		String sql = "SELECT * bank_log";
		PreparedStatement ps;
		
		System.out.println("and here is the list of transactions");
	}


	
}
