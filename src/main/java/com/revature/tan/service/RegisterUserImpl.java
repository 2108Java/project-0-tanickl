package com.revature.tan.service;



import java.sql.Connection;

import com.revature.tan.models.User;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.repo.UserDAOImpl;


public class RegisterUserImpl implements RegisterUser {

	private UserDAO uDAO;
	private ConnectionMaker conn = new ConnectionMaker();
	//I think this is a layer that has to query DAO

	public RegisterUserImpl() {
	
	}

	
	
	@Override
	public boolean checkUsername(String a) { //SELECT from tables & check that username is unique
		ConnectionMaker conn = new ConnectionMaker();
		Connection connection = conn.getConnection();
		UserDAO uDAO = new UserDAOImpl();
		return uDAO.selectUniqueUserName(a); //true if unique
	}

	
	



	@Override
	public void registerNewUser(String username, String pass, boolean isEmp) {
		ConnectionMaker conn = new ConnectionMaker();
		UserDAO uDAO = new UserDAOImpl();		
		uDAO.insertNewUser(username, pass, isEmp);
		
	}


	

}
