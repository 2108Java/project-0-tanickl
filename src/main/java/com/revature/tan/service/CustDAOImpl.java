package com.revature.tan.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import com.revature.tan.*;
import com.revature.tan.models.User;
import com.revature.tan.repo.CustDAO;
import com.revature.tan.service.ConnectionMaker;

public class CustDAOImpl implements CustDAO {


	//FIELDS
	private ConnectionMaker conn = new ConnectionMaker();




	//FROM DISPLAYIMPL
	
	@Override
	public void mkAccount() { //INSERT into table accounts ...
		
		Connection connection = conn.getConnection();
		String sql = "INSERT into accounts WHERE username = ?"; //finish
		PreparedStatement ps;
		User u = null;
//		try {						//EDIT THIS BLOCK
//			ps = connection.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				u.setUserId(rs.getInt("user_id"));
//				u.setUserName(rs.getString("username"));
//				u.setUserPass(rs.getString("pword"));
//			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		

	
	


	public void viewAccounts() { //SELECT from accounts WHERE user ...
		Connection connection = conn.getConnection();
		String sql = "SELECT * accounts WHERE username = ?"; //finish
		PreparedStatement ps;
		User u = null;
//		try {						//EDIT THIS BLOCK
//			ps = connection.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				u.setUserId(rs.getInt("user_id"));
//				u.setUserName(rs.getString("username"));
//				u.setUserPass(rs.getString("pword"));
//			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		



	public void viewTransactions() { //SELECT from table transactions WHERE ...
		Connection connection = conn.getConnection();
		String sql = "SELECT from bank_log WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		User u = null;
//		try {						//EDIT THIS BLOCK
//			ps = connection.prepareStatement(sql);
//			ps.setString(1, username); //not username, but match to accounts(account_owner)
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				u.setUserId(rs.getInt("user_id"));
//				u.setUserName(rs.getString("username"));
//				u.setUserPass(rs.getString("pword"));
//			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("This is last line of viewTransactions");
		
}		


	public void mkDeposit() { 	//UPDATE table accounts ...
		Connection connection = conn.getConnection();
		String sql = "UPDATE accounts WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		
		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;				//INSERT into tables transactions
		
	}


	public void mkWithdraw() { //UPDATE table accounts ...
		Connection connection = conn.getConnection();
		String sql = "UPDATE accounts WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		
		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;							//INSERT into tables transactions
		
	}


	public void mkTransfer() { //UPDATE table accounts ...
		Connection connection = conn.getConnection();
		String sql = "UPDATE accounts WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		
		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;							//INSERT into tables transactions
		
	}


	public void mkTransferOut() { //UPDATE table accounts
		Connection connection = conn.getConnection();
		String sql = "UPDATE accounts WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		
		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;								//INSERT into tables transactions
		
	}

	
}
