package com.revature.tan.repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;



public class BankDAOImpl implements BankDAO {

		//consider changing to AWS
	String url = "jdbc:postgresql://localhost/5432/postgres";
	String username = "postgres";
	String password = "passWORD";
	
	
	 		
		@Override
		public boolean applyForNewAcct() {
			boolean status = false;
			try (Connection conn = DriverManager.getConnection(url, username, password)){
				
				String sql = "INSERT into table users (firstname, lastname, username, pword) "
						+ "VALUES ()"; //variable names from scanner, which layer?
						
				PreparedStatement ps = conn.prepareStatement(sql);
				status = true;
				
				} catch(SQLException e) {
				e.printStackTrace();
			} return status;
		}
		

		
		
		//This method will query the DAO to test whether user&pass match and return loggedIn as true
		@Override
		public boolean checkUserLogin() {
			boolean loggedIn = false;
			
			try (Connection conn = DriverManager.getConnection(url, username, password)){
				
				String sqlForUserKey = "SELECT from users WHERE " 
						+ "username='" + userFromScanner + "'"; 
							//variable names from scanner, which layer?
				
				PreparedStatement psUser = conn.prepareStatement(sqlForUserKey);
				
							//prob need to do multiple try&catch
				String sqlForPassKey = "SELECT from credentials WHERE "
						+ "pword='" + passFromScanner + "'";
				
				PreparedStatement psPass = conn.prepareStatement(sqlForPassKey);
				
				ResultSet rsUser = psUser.executeQuery();
				ResultSet rsPass = psPass.executeQuery();
				
				if (rsUser.getInt(userId) == rsPass.getInt(foreign key)) { //syntax is wrong
					boolean match = true;
					final loggedIn = true;}
				} catch(SQLException e) {
				e.printStackTrace();
				}
			return loggedIn;
			}



	
		
		
		
		@Override
		public List<Account> getMyAccounts() {
			
		}
			//use a generic to make handling multiple accounts easier
			//I think it will be simpler to have separate methods for employee & customer
		
		
		
		
		@Override
		public boolean makeDeposit() {
			
		}
			//boolean will check whether successful
		
		
		
		
		@Override
		public boolean makeWithdrawal() {
			
		}
			//same as above
		
		//public boolean addJointUser();
			//this was a stretch goal, so omit for now
		
		
		
		
		@Override
		public boolean approvePendingAccount() {
			
		}
			//employee approve
		
		
		
		
		@Override
		public boolean approveAllPending() {
			
		}
		
		
		
		
		@Override
		public List<Account> viewTransactionLog() {
			
		}
	

//last line
}

///////notes
//example from todo app of how to use connection

