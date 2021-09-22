package com.revature.tan.service;

import java.sql.SQLException;
import java.util.Scanner;
import com.revature.tan.*;
import com.revature.tan.models.User;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.UserDAOImpl;
import java.sql.Connection;

public class AuthenticateImpl implements Authenticate {

	private UserDAO uDAO;
	
	private ConnectionMaker conn = new ConnectionMaker();
	
	public AuthenticateImpl() {
		
	}

	
	User u;

	@Override
	public boolean validUser(String userName) { //SELECT from users
		Authenticate auth = new AuthenticateImpl();
		User u = auth.getUser(userName);
		if(u == null) {
			return false;
		} else {
			return true;
			}
	}


	@Override
	public boolean validUserAndPass(String userName, String userPass) { //SELECT from users
		Authenticate auth = new AuthenticateImpl();
		User u = auth.getUser(userName);
		if(u.getUserPass().equals(userPass)) {
			return true;
		} else {
			return false;
			}
	}
	


	@Override
	public User getUser(String username) { //SELECT from users
		User u = null;
		UserDAO uDAO = new UserDAOImpl();
		u = uDAO.selectUserByUserName(username);
		return u;
	}


}


