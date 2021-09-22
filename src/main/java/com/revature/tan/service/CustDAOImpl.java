package com.revature.tan.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.revature.tan.*;
import com.revature.tan.models.User;
import com.revature.tan.models.*;
import com.revature.tan.repo.CustDAO;
import com.revature.tan.service.ConnectionMaker;

public class CustDAOImpl implements CustDAO {


	//FIELDS
	private ConnectionMaker conn = new ConnectionMaker();



	//FROM DISPLAYIMPL
	
	@Override
	public void mkAccount(Account a) { //INSERT into table accounts ...
		double startBal;
		Connection connection = conn.getConnection();
		String sql = "insert into bsim_accounts (balance, type_of, fk_user) values ( ?, ?, ?)";
		PreparedStatement ps;
		try {						
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, a.getBalance());
			ps.setString(2, a.getAcctType());
			ps.setInt(3, a.getUserForKey());
			ResultSet rs = ps.executeQuery();
			}
		//	connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		

	
	


	public void viewAccounts(Account a) { //SELECT from accounts WHERE user ...
		int fk = a.getUserForKey();
		Connection connection = conn.getConnection();
		String sql = "SELECT * from bsim_accounts WHERE fk_user = ?"; 
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(0, fk);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void viewTransactions(User u) { //SELECT from table transactions WHERE ...
		Connection connection = conn.getConnection();
		String sql = "SELECT from bsim_log WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		User u = //
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


	public void mkDeposit(Account a, double amt) { 
		Connection connection = conn.getConnection();
		String sql = "UPDATE bsim_accounts SET balance = ?  WHERE acct_num = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, 0);
		}
		
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



	//CALLED FROM DISPLAY
	@Override
	public void mkAccount() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void viewAccounts() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void viewTransactions() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mkDeposit(User u) {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		
	}

	
}
