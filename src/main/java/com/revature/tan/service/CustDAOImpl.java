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
import com.revature.tan.models.*;
import com.revature.tan.repo.CustDAO;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.ConnectionMaker;

public class CustDAOImpl implements CustDAO {


	//FIELDS
//	private Connection connection = ConnectionMaker.getConnection();



	//FROM DISPLAYIMPL
	
	@Override
	public void mkAccount(Account a) {
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
//		this.connection = ConnectionMaker.getConnection();
//		Connection connection = conn.getConnection();
		String sql = "insert into bsim_accounts (balance, type_of, fk_user) values ( ?, ?, ?)";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, a.getBalance());
			ps.setString(2, a.getAcctType());
			ps.setInt(3, a.getUserForKey());
			ResultSet rs = ps.execute();
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public User viewAccounts(User u) {
		
		UserDAO uDAO = new UserDAOImpl();
		return uDAO.getUser(u);
	}


	public void viewAccounts(Account a) { //SELECT from accounts WHERE user ...
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
//		this.connection = ConnectionMaker.getConnection();
		int fk = a.getUserForKey();
		String sql = "SELECT * from bsim_accounts WHERE fk_user = ?"; 
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(0, fk);
			ResultSet rs = ps.executeQuery(); //execute
			System.out.println(rs.toString());
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void viewTransactions(User u) { 
		System.out.println("Here are your transactions:");
		Displays next = new DisplaysImpl(u);
		//SELECT from table transactions WHERE ...
	}
//		Connection connection = conn.getConnection();
//		String sql = "SELECT from bsim_log WHERE  = ?"; //finish , make sure rs is debit and credit
//		PreparedStatement ps;
//		User u = //
////		try {						//EDIT THIS BLOCK
////			ps = connection.prepareStatement(sql);
////			ps.setString(1, username); //not username, but match to accounts(account_owner)
////			ResultSet rs = ps.executeQuery();
////			while(rs.next()) {
////				u.setUserId(rs.getInt("user_id"));
////				u.setUserName(rs.getString("username"));
////				u.setUserPass(rs.getString("pword"));
////			}
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("This is last line of viewTransactions");
		
//}		


	public User mkDeposit(Account a, double y) { 
//		this.connection = ConnectionMaker.getConnection();
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		String sql = "UPDATE bsim_accounts SET balance = ?  WHERE acct_num = ?";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			double z = (a.getBalance() + y);
			ps.setDouble(1,z);
			ps.setInt(2, a.getPkAcct());
			ps.execute();
//			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Sorry but that deposit was not successful.");
		}
		User u = new User();
		u.setUserId(a.getUserForKey());
		return u;
		
//		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
//		PreparedStatement ps;				//INSERT into tables transactions
//		
	}


	public void mkWithdraw(Account a, double z) { //UPDATE table accounts ...
//		this.connection = ConnectionMaker.getConnection();
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		String sql = "UPDATE bsim_accounts SET balance = ?  WHERE acct_num = ?";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			double r = (a.getBalance() + z);
			ps.setDouble(1,r);
			ps.setInt(2, a.getPkAcct());
			ps.execute();
//			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Sorry but that deposit was not successful.");
		}
//		User u = new User();			//don't know why I had this block!
//		u.setUserId(a.getUserForKey());
//		return u;
	}


	public void mkTransfer() { //UPDATE table accounts ...
//		this.connection = ConnectionMaker.getConnection();
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		String sql = "UPDATE bsim_accounts SET balance = ? WHERE  = ?";
		PreparedStatement ps;
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//		rs.close();
		ps.close();
		connection.close();
//		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
//		PreparedStatement ps;							//INSERT into tables transactions
		
	}


	public void mkTransferOut(int tdebit, String trUser, double amt2) { //UPDATE table accounts
//		this.connection = ConnectionMaker.getConnection();
		String sql = "UPDATE accounts WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;
		
		String sql2 = "UPDATE bank_log () WHERE  = ?"; //finish , make sure rs is debit and credit
		PreparedStatement ps;								//INSERT into tables transactions
		
	}








	@Override
	public void mkTransfer(int debit, int credit, double amt) {
		// TODO Auto-generated method stub
		
	}













	
}
