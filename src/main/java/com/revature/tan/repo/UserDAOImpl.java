package com.revature.tan.repo;

import java.sql.Connection;

import com.revature.tan.models.User;
import com.revature.tan.service.ConnectionMaker;

public class UserDAOImpl implements UserDAO {

	private ConnectionMaker conn;
	
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User selectUserByUserName(String username) {
		Connection connection = conn.getConnection();
		return null;
	}

}
