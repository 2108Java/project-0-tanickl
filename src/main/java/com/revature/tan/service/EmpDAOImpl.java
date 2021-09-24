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
import com.revature.tan.repo.EmpDAO;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.*;

public class EmpDAOImpl implements EmpDAO {

	//FIELDS
	private Connection connection = ConnectionMaker.getConnection();
	
	
	//CONSTRUCTORS
	public EmpDAOImpl() {
		// TODO Auto-generated constructor stub
	}


	//METHODS from EmpDAO
	@Override
	public void viewAll() { // SELECT from ACCOUNTS
//		this.connection = ConnectionMaker.getConnection();
		String sql = "SELECT * FROM bsim_accounts"; //ben didn't use ; inside string
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.toString());
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void viewByName(String custUserName) { 
		this.connection = ConnectionMaker.getConnection();
		String sql = "SELECT * FROM bsim_accounts WHERE username = ?";
		PreparedStatement ps;
		User u2 = new User();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, custUserName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Here is your result: " + rs.toString());
//				u2.setUserId(rs.getInt("user_id"));
//				u2.setUserName(rs.getString("username"));
//				u2.setUserPass(rs.getString("pword"));
			} 
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		

	@Override
	public void approvePending() { //UPDATE 
		this.connection = ConnectionMaker.getConnection();
		String sql = "SELECT * bsim_accounts WHERE is_approved = false;"; //check this
		PreparedStatement ps;
		
		//then I want to print the ResultSet, 
		try {
			ps = connection.prepareStatement(sql);
//			ps.setString(1, custUserName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Here is your result: " + rs.toString());
				} 
//			connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
		
		//and then give option to approve
				System.out.println("Enter the account number to approve:");
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
//		this.connection = ConnectionMaker.getConnection();
		String sql2 = "update";// this will actually be the update ... "SELECT * bsim_accounts WHERE is_approved = false;"; //check this
		PreparedStatement ps2;
		try {
			ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, choice);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				System.out.println("Here is your result: " + rs2.toString());
				} 
			rs.close();
			ps.close();
			connection.close();
			} catch (SQLException ee) {
				e.printStackTrace();
		} System.out.println("End of approvePending");
	}
}
	
	
	@Override
	public void viewLog() { //SELECT // OR SHOULD I JUST USE LOG4J
//		this.connection = ConnectionMaker.getConnection();
		String sql = "SELECT * bsim_log";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Here is your result: " + rs.toString());
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("end of viewLog");
	}





	@Override
	public void selectPending() {
//		this.connection = ConnectionMaker.getConnection();
		String sql = "SELECT * bsim_log";
		PreparedStatement ps;
	
//		rs.close();
		ps.close();
		connection.close();
		System.out.println("end of selectPending");
	}





	@Override
	public void rejectPending() {
		

		
	}

}
	
