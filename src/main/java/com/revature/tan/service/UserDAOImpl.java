package com.revature.tan.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.tan.models.Account;
import com.revature.tan.models.User;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.ConnectionMaker;

public class UserDAOImpl implements UserDAO {

//	private ConnectionMaker conn = new ConnectionMaker();
	
	public UserDAOImpl() {
		
	}

	
	@Override
	public User selectUserByUserName(String username) {
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		
		
//		Connection connection = conn.getConnection();
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
//			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	
	@Override
	public User insertNewUser(String username, String pass, boolean isEmp) {
		ConnectionMaker conn = new ConnectionMaker();
		Connection connection = conn.getConnection();
		String sql = "INSERT INTO bsim_users (username, pword) values (?, ?)"; //or is it ('?', '?');"
		PreparedStatement ps;
		User u = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery(); //try executeUpdate(); next
			//gotta return a user, but hwo?
			u = selectUserByUserName(username);
//			connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
		} return u;
	}
	
	
	
	@Override
	public boolean selectUniqueUserName(String a) {
		String a = ;
		String sql = "SELECT * FROM bsim_users WHERE username = ?";
		PreparedStatement ps;
		User u = null;
		try {
//			ps = connection.prepareStatement(sql);
			ps.setString(1, a);
			ResultSet rs = ps.executeQuery();
			if(a.equals(rs.getString(2))) {
				return true;
			} 
//			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	@Override
	public User selectUserById(Account a) {
		User u = new User();
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
			
//		Connection connection = conn.getConnection();
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
//			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

}
