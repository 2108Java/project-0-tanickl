package com.revature.tan.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.tan.service.ConnectionMaker;
import com.revature.tan.models.Account;
import com.revature.tan.models.User;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.ConnectionMaker;

public class UserDAOImpl implements UserDAO {

	//FIELDS
//	private Connection connection = ConnectionMaker.getConnection();
	
	
	public UserDAOImpl() {

		
	}

	
//	@Override 
//	public List<Account> getAccountsByUserId(int fk){
//		
//		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
//		final String USERNAME= "postgres";
//		final String PASSWORD = "49STOREdata40$16";
//		String sql = "SELECT * FROM bsim_accounts WHERE fk_user = ?";
//		PreparedStatement ps;
//		List<Account> custAcctList = new ArrayList<Account>();
//		
//		try {
//			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			ps = connection.prepareStatement(sql);
//			ps.setString(1, );
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//			}
//		}
//	}

	@Override
	public User getUser(String username) { //SELECT from users
			
		return selectUserByUserName(username);
	}
	
	
	
	@Override
	public User selectUserByUserName(String username) {

		//these were here just a test for debugging connection
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
//		Connection connection = conn.getConnection();		
		
//		this.connection = ConnectionMaker.getConnection();		
		String sql = "SELECT * FROM bsim_users WHERE username = ?";
		PreparedStatement ps;
		User u = new User();
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserId(rs.getInt("user_id"));
				u.setUserName(rs.getString("username"));
				u.setUserPass(rs.getString("pword"));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		//Test
		System.out.println("UDAOImpl returns user as " + u.toString());
		return u; //check here
	}

	
	@Override
	public User insertNewUser(String username, String pass, boolean isEmp) {
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
//		ConnectionMaker conn = new ConnectionMaker();
//		Connection connection = conn.getConnection();
		String sql = "INSERT INTO bsim_users (username, pword, is_emp) values (?, ?, ?)"; //or is it ('?', '?');"
		PreparedStatement ps;
		User u = null;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ps.setBoolean(3, isEmp);
			boolean success = ps.execute();
			u = selectUserByUserName(username);
//			rs.close();
			ps.close();
			connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sorry, but that username is taken.");
			Displays next = new DisplaysImpl();
			next.displayRegisterNewUser();
		} return u;
	}
	
	
	
	@Override
	public boolean selectUniqueUserName(String a) {
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		System.out.println("System is searching for the username " + a);
		String sql = "SELECT * FROM bsim_users WHERE username = ?";
		PreparedStatement ps;
//		User u = null;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setString(1, a);
			ResultSet rs = ps.executeQuery();
			if(a.equals(rs.getString(2))) {
				return true;
			} 
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public User selectUserById(Account a) {
		User u = new User();
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
			

		String sql = "SELECT * FROM bsim_accounts WHERE fk_user = ?";
		PreparedStatement ps;
		
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, a.getUserForKey());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserId(rs.getInt("user_id"));
				u.setUserName(rs.getString("username"));
				u.setUserPass(rs.getString("pword"));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}


	@Override
	public User getUser(User u) {
		String username = u.getUserName(); 
		return selectUserByUserName(username);
	}

}
