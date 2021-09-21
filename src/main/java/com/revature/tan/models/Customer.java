package com.revature.tan.models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import com.revature.tan.*;
import com.revature.tan.repo.CustomerDAO;

public class Customer extends User implements CustomerDAO {

	//FIELDS //keep these? I can probably just SQL logic do the same
			//or maybe getObject();?
	private List<Account> accountSummary;
	private List<Transactions> actionSummary;
	
	//CONSTRUCTOR // Do I ever pass args to the Cust constructor?
	public Customer(int userId, String userName, String userPass) {
		userId = this.getUserId();
		userName = this.getUserName();
		userPass = this.getUserPass();
	}
	
	
	public Customer() {
		this.userId = this.getUserId();
		this.userName = this.getUserName();
		this.userPass = this.getUserPass();
	}

	
	//I might not need these, or if I do I might need something different in DAO
//	public List<Account> getAccountSummary() {
//		return accountSummary;
//	}
//
//	public void setAccountSummary(List<Account> accountSummary) {
//		this.accountSummary = accountSummary;
//	}
//
//	public List<Transactions> getActionSummary() {
//		return actionSummary;
//	}
//
//	public void setActionSummary(List<Transactions> actionSummary) {
//		this.actionSummary = actionSummary;
//	}

	
	
	
	
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
		
		return u;
		
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
		
		return u;
		
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
		}
		
		return u;
		
	}


	public void mkDeposit(double x) { 	//UPDATE table accounts ...
		Connection connection = conn.getConnection();
		String sql = "UPDATE accounts WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		
		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;				//INSERT into tables transactions
		
	}


	public void mkWithdraw(double x) { //UPDATE table accounts ...
								//INSERT into tables transactions
		
	}


	public void mkTransfer(double x) { //UPDATE table accounts ...
								//INSERT into tables transactions
		
	}


	public void mkTransferOut(double x) { //UPDATE table accounts
									//INSERT into tables transactions
		
	}


	public void mkJoint() { //INSERT INTO table JOINT ACCOUNTS 
		
	}
	
}
