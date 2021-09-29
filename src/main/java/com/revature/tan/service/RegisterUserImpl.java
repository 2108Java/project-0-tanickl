package com.revature.tan.service;



import java.sql.Connection;

import com.revature.tan.models.User;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.repo.UserDAOImpl;


public class RegisterUserImpl implements RegisterUser {

	//FIELDS
	private UserDAO uDAO = new UserDAOImpl();


	//CONSTR
	public RegisterUserImpl() {
	
	}

	
	
	//METHODS
	
	@Override
	public boolean checkUsername(User u) {

		String a = u.getUserName();
		return uDAO.selectUniqueUserName(a); //true if unique
	}


	@Override
	public boolean checkUsername(String a) {
		return uDAO.selectUniqueUserName(a); //true if unique
	}
	



//	@Override
//	public void registerNewUser(String username, String pass, boolean isEmp) {
//		uDAO.insertNewUser(username, pass, isEmp);
//		
//	}

	@Override
	public void registerNewUser(User u) {
		
		uDAO.insertNewUser(u);
	}



	

}
