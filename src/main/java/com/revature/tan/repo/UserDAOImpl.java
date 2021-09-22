package com.revature.tan.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.tan.models.User;
import com.revature.tan.service.ConnectionMaker;

public class UserDAOImpl implements UserDAO {

	private ConnectionMaker conn = new ConnectionMaker();
	
	public UserDAOImpl() {
		
	}

	
	@Override
	public User selectUserByUserName(String username) {
		Connection connection = conn.getConnection();
		String sql = "SELECT * FROM bsim_users WHERE username = ?";
		PreparedStatement ps;
		User u = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserId(rs.getInt("user_id"));
				u.setUserName(rs.getString("username"));
				u.setUserPass(rs.getString("pword"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	
	@Override
	public User insertNewUser(String username, String pass, boolean isEmp) {
		
		Connection connection = conn.getConnection();
		String sql = "INSERT INTO bsim_users (username, pword) values (?, ?)"; //or ('?', '?');"
		PreparedStatement ps;
		User u = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery(); //try executeUpdate(); next
			//gotta return a user, but hwo?
			u = selectUserByUserName(username);
			connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
		} return u;
	}
	
	
	
	@Override
	public boolean selectUniqueUserName(String a) {
		ConnectionMaker conn = new ConnectionMaker();
		Connection connection = conn.getConnection();
		String sql = "SELECT * FROM bsim_users WHERE username = ?";
		PreparedStatement ps;
		User u = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, a);
			ResultSet rs = ps.executeQuery();
			if(a.equals(rs.getString(2))) {
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}




}
