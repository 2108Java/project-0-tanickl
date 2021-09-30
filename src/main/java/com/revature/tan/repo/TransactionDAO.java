package com.revature.tan.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.tan.models.Account;
import com.revature.tan.models.User;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;

public class TransactionDAO {

	//deb_acct, cred_acct, amount, description //is order of table columns in ddl
	
	
	//TRANSFER, whether inter- intra-
	public static void insertTransfer(int debitAcct, int creditAcct, double amt, String desc) {
			
			final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
			final String USERNAME= "postgres";
			final String PASSWORD = "49STOREdata40$16";

			String sql = "insert into bsim_log (deb_acct, cred_acct, amount, description, datetime) "
					+ "values ( ?, ?, ?, ?, now()) returning *";
			
			PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ps.setInt(1, debitAcct);
				ps.setInt(2, creditAcct);
				ps.setDouble(3, amt);
				ps.setString(4, desc);
				ResultSet rs = ps.executeQuery();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	

	//Withdrawal
	public static void insertWithdraw(int debitAcct, double amt, String desc) {
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
	
		String sql = "insert into bsim_log (deb_acct, amount, description, datetime)"
				+ "values ( ?, ?, ?, now()) returning *"; //maybe drop returning
		
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, debitAcct);
			ps.setDouble(2, amt);
			ps.setString(3, desc);
			ResultSet rs = ps.executeQuery();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			


		
		public static void insertDeposit(int creditAcct, double amt, String desc) {
			
			final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
			final String USERNAME= "postgres";
			final String PASSWORD = "49STOREdata40$16";
		
			String sql = "insert into bsim_log (cred_acct, amount, description, datetime) "
					+ "values ( ?, ?, ?, now()) returning *"; //maybe drop returning
			
			PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ps.setInt(1, creditAcct);
				ps.setDouble(2, amt);
				ps.setString(3, desc);
				ResultSet rs = ps.executeQuery();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		public static void changePending(int debitAcct, String desc) {
			
			final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
			final String USERNAME= "postgres";
			final String PASSWORD = "49STOREdata40$16";
		
			String sql = "insert into bsim_log (deb_acct, description, datetime) "
					+ "values ( ?, ?, now()) returning *"; //maybe drop returning
			
			PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ps.setInt(1, debitAcct);
				ps.setString(2, desc);
				ResultSet rs = ps.executeQuery();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//class body
}