package com.revature.tan.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.revature.tan.*;
import com.revature.tan.models.*;
import com.revature.tan.presentation.AbstractDisplays;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;
import com.revature.tan.repo.CustDAO;
import com.revature.tan.repo.TransactionDAO;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.ConnectionMaker;


public class CustDAOImpl implements CustDAO {

	private static final org.apache.logging.log4j.Logger BANKLOG = LogManager.getLogger();
	
	//FIELDS
//	private Connection connection = ConnectionMaker.getConnection();
	private Account a;
	private Account b;
	private User u;
//	private ArrayList<Account> acctListFromDAO;


	
	//CONSTRUCTORS
	public CustDAOImpl() {
		this.a = new Account();
		this.b = new Account();
		this.u = new User();
	}
	

	
	
	
	//FROM DISPLAYIMPL
	
	@Override
	public User mkAccount(Account a, User u) {
		this.a = a;
		this.b = b;
		this.u = u;
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";

		String sql = "insert into bsim_accounts (balance, type_of, user_id) values ( ?, ?, ?) returning *";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, a.getBalance());
			ps.setString(2, a.getAcctType());
			ps.setInt(3, a.getUserForKey());
			ResultSet rs = ps.executeQuery();	
					while(rs.next()) {
							b.setPkAcct(rs.getInt("acct_num"));
							b.setApproved(rs.getBoolean("is_approved"));
						    b.setBalance(rs.getDouble("balance"));
						    b.setUserForKey(rs.getInt("user_id"));
						    b.setAcctType(rs.getString("type_of")); //try "acct_type" next   
						   System.out.println("Here are the details for your new account: ");
						   BANKLOG.info("A new account was created: " + u.toString());
						   System.out.println(b.toString());
					}

			ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
			acctListFromDAO.add(b);
			u.setUserAcctList(acctListFromDAO);	
			System.out.println("Here is a summary of your accounts, " + u.getUserName() + ":");
			System.out.println(u.getUserAcctList().toString());
			rs.close(); //maybe cut these methods: close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} Displays next = new DisplaysImpl(u);
		next.displayCust(u);
		return u; //might not be necessary, since I'm calling next.displayCust(u); just change to void tho
	}
	
	


	public User viewAccounts(User u) {
//		this.a = a;
//		this.b = b;
		this.u = u;
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		String sql = "select * from bsim_accounts where user_id = ?";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ResultSet rs = ps.executeQuery();	
			ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
			while(rs.next()) {
					Account acct = new Account();
					acct.setPkAcct(rs.getInt("acct_num"));
					acct.setApproved(rs.getBoolean("is_approved"));
					acct.setBalance(rs.getDouble("balance"));
					acct.setUserForKey(rs.getInt("user_id"));
					acct.setAcctType(rs.getString("type_of"));
//				    ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
//					acctListFromDAO.add(acct);
				    System.out.println(acct.toString());

			} 
//			u.setUserAcctList(acctListFromDAO);	
//			System.out.println("Here is a summary of your accounts, " + u.getUserName() + ":");
//			Object[] acctArrayFromDAO = acctListFromDAO.toArray();
//			System.out.println(acctArrayFromDAO.toString()); unnecessary for now
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} Displays next = new DisplaysImpl(u);
		next.displayCust(u);
		return u; //might not be necessary, since I'm calling next.displayCust(u); just change to void tho
	}
	






	public void viewTransactions(User u) { 
		this.u = u;
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		String sql = "select * from \r\n"
				+ "bsim_log inner join bsim_accounts \r\n"
				+ "on bsim_log.deb_acct = bsim_accounts.acct_num where user_id=? \r\n"
				+ "union \r\n"
				+ "select * from \r\n"
				+ "bsim_log inner join bsim_accounts \r\n"
				+ "on bsim_log.cred_acct = bsim_accounts.acct_num where user_id=? ";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setInt(2, u.getUserId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(" ---------------- ");
				System.out.println("Transaction number: " + rs.getInt("trans_num"));
				System.out.println("Involved Accounts: " + rs.getInt("deb_acct") + " and " + rs.getInt("cred_acct"));
				System.out.println("Amount: " + rs.getDouble("amount"));
				System.out.println("Description: " + rs.getString("description"));
				System.out.println("Timestamp: " + rs.getDate("datetime")); //try toString next, or getStream
				System.out.println(" ---------------- ");
				System.out.println(" ");
				System.out.println(" ");
			} connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}




	
	
	
	public User mkDeposit(User u) { 
		this.u = u;
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		String sql = "select * from bsim_accounts where user_id = ?";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ResultSet rs = ps.executeQuery();	
//			ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
			System.out.println("Here is a summary of your accounts. Choose the account number to "
					+ "which you will deposit.");
			
			while(rs.next()) {
					Account acct = new Account();
					acct.setPkAcct(rs.getInt("acct_num"));
					acct.setApproved(rs.getBoolean("is_approved"));
					acct.setBalance(rs.getDouble("balance"));
					acct.setUserForKey(rs.getInt("user_id"));
					acct.setAcctType(rs.getString("type_of"));
//				    ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
//					acctListFromDAO.add(acct);
					System.out.println(acct.toString());

			} rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number to which you'll DEPOSIT:");
		int creditAcct = sc.nextInt();
		System.out.println("Enter the amount to DEPOSIT to account number " + creditAcct + ":");
		double y = sc.nextDouble();

		String sql2 = "UPDATE bsim_accounts SET balance = balance + ?  WHERE acct_num = ? returning *";
		PreparedStatement ps2;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps2 = connection.prepareStatement(sql2);
			ps2.setDouble(1, y);
			ps2.setInt(2, creditAcct);
			boolean success = ps2.execute();
			if(success) {
				String depDesc = "A DEPOSIT of " + y + " was made to account number " + creditAcct;
				TransactionDAO.insertDeposit(creditAcct, y, depDesc);
				BANKLOG.info(depDesc);
				System.out.println("Your DEPOSIT was successful.");
			} else {
				System.out.println("Sorry but that DEPOSIT was not successful.");
			}
			ps2.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} return u;		
	}


	
	
	
	public User mkWithdraw(User u) {
		this.u = u;
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		String sql = "select * from bsim_accounts where user_id = ?";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ResultSet rs = ps.executeQuery();	
			ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
			System.out.println("Here is a summary of your accounts. Choose the account number from "
					+ "which you will WITHDRAW.");
			
			while(rs.next()) {
					Account acct = new Account();
					acct.setPkAcct(rs.getInt("acct_num"));
					acct.setApproved(rs.getBoolean("is_approved"));
					acct.setBalance(rs.getDouble("balance"));
					acct.setUserForKey(rs.getInt("user_id"));
					acct.setAcctType(rs.getString("type_of"));

				    System.out.println(acct.toString());
			} 

			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number from which you'll WITHDRAW:");
		int debitAcct = sc.nextInt();
		System.out.println("Enter the amount to WITHDRAW from account number " + debitAcct + ":");
		double y = sc.nextDouble();

		String sql2 = "UPDATE bsim_accounts SET balance = balance - ?  WHERE acct_num = ? returning *";
		PreparedStatement ps2;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps2 = connection.prepareStatement(sql2);
			ps2.setDouble(1, y);
			ps2.setInt(2, debitAcct);
			boolean success = ps2.execute();
			if(success) {
				
				String desc = "A WITHDRAWAL of " + y + " was made from account number " + debitAcct;
				TransactionDAO.insertWithdraw(debitAcct, y, desc);
				BANKLOG.info(desc);
				System.out.println("Your WITHDRAWAL was successful.");
				System.out.println(" ---------------- ");
			} else {
				System.out.println("Sorry but that WITHDRAWAL was not successful.");
				System.out.println(" ---------------- ");
			}
			ps2.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} return u;
	}


	
	
	
	public User mkTransfer(User u) {
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		this.u = u;
		
		String sql = "select * from bsim_accounts where user_id = ?";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ResultSet rs = ps.executeQuery();	
			ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
			System.out.println("Here is a summary of your accounts. Choose the account number from "
					+ "which you will DEBIT for this TRANSFER.");
			
			while(rs.next()) {
					Account acct = new Account();
					acct.setPkAcct(rs.getInt("acct_num"));
					acct.setApproved(rs.getBoolean("is_approved"));
					acct.setBalance(rs.getDouble("balance"));
					acct.setUserForKey(rs.getInt("user_id"));
					acct.setAcctType(rs.getString("type_of"));
				    System.out.println(acct.toString());
			} 
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number which you'll DEBIT for this TRANSFER:");
		int debitAcct = sc.nextInt();
		System.out.println("Enter the account number which you'll CREDIT for this TRANSFER:");
		int creditAcct = sc.nextInt();
		System.out.println("Enter the amount to TRANSFER from account number " + debitAcct + "to "
				+ "account number " + creditAcct);
		double y = sc.nextDouble();
		
		String sql2 = "begin;\r\n"
				+ " update bsim_accounts set balance = balance - ? \r\n"
				+ " where acct_num = ?;\r\n"
				+ " update bsim_accounts set balance = balance + ? \r\n"
				+ " where acct_num = ?;\r\n"
				+ "COMMIT;";
		PreparedStatement ps2;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		ps2 = connection.prepareStatement(sql2);
		ps2.setDouble(1, y);
		ps2.setInt(2, debitAcct);
		ps2.setDouble(3, y);
		ps2.setInt(4, creditAcct);
		ps2.execute();
		String transferDesc = "A TRANSFER of " + y + " was CREDITED to account number " 
				+ creditAcct + " and DEBITED from " + debitAcct;
		TransactionDAO.insertTransfer(debitAcct, creditAcct, y, transferDesc);
		BANKLOG.info(transferDesc);
		System.out.println("Your TRANSFER was successful.");
		System.out.println(" ---------------- ");
		
		} catch	(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}


	public User mkTransferOut(User u) {
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		this.u = u;
		
		String sql = "select bsim_users.username, bsim_accounts.acct_num, bsim_accounts.type_of from bsim_users "
				+ "inner join bsim_accounts on bsim_users.user_id = bsim_accounts.user_id \r\n"
				+ "	where bsim_users.is_emp = false;";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();	
			System.out.println("Here is a list of customer account numbers and types grouped by their"
					+ "owner's usernames. Your accounts are included in this list. "
					+ "Find the account number whose owner you will CREDIT by TRANSFERRING "
					+ "funds from one of your own accounts.");
			
			////figure this out
			while(rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getInt("acct_num"));
				System.out.println(rs.getString("type_of"));
				System.out.println(" ");
				System.out.println(" ");
			} 
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Which of YOUR accounts will you DEBIT for this transfer:");
		int debitAcct = sc.nextInt();
			//might need to add check that DEBIT account BELONGS to USER!
		System.out.println("Enter the account number of ANOTHER CUSTOMER which you'll CREDIT for this TRANSFER:");
		int creditAcct = sc.nextInt();
		System.out.println("Enter the amount to TRANSFER from account number " + debitAcct + "to "
				+ "account number " + creditAcct);
		double y = sc.nextDouble();
		
		String sql2 = "begin;\r\n"
				+ " update bsim_accounts set balance = balance - ? \r\n"
				+ " where acct_num = ?;\r\n"
				+ " update bsim_accounts set balance = balance + ? \r\n"
				+ " where acct_num = ?;\r\n"
				+ "COMMIT;";
		PreparedStatement ps2;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		ps2 = connection.prepareStatement(sql2);
		ps2.setDouble(1, y);
		ps2.setInt(2, debitAcct);
		ps2.setDouble(3, y);
		ps2.setInt(4, creditAcct);
		ps2.execute();
		String desc = "A TRANSFER of " + y + " was CREDITED to account number " + creditAcct
				+ " and DEBITED from " + debitAcct;
		TransactionDAO.insertTransfer(debitAcct, creditAcct, y, desc);
		BANKLOG.info(desc);
		System.out.println("Your TRANSFER was successful.");
		System.out.println(" ---------------- ");
		} catch	(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}

	

