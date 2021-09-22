package com.revature.tan.presentation;

import com.revature.tan.*;
import com.revature.tan.models.User;
import com.revature.tan.repo.CustDAO;
import com.revature.tan.repo.EmpDAO;
import com.revature.tan.service.Authenticate;
import com.revature.tan.service.AuthenticateImpl;
import com.revature.tan.service.CustDAOImpl;
import com.revature.tan.service.EmpDAOImpl;
import com.revature.tan.service.RegisterUser;
import com.revature.tan.service.RegisterUserImpl;

import java.util.Scanner;

public class DisplaysImpl extends AbstractDisplays implements Displays {

	//FIELDS
	private String currentMenu;
	private User u;
	
	//CONSTRUCTORS
	public DisplaysImpl() {
	}
	

	
	
	
	//MISC METHODS
	private void sayHeader() {
		System.out.println("You are now viewing the " + this.currentMenu);
	}

	
	
	private void saySorry() {
		System.out.println("Sorry, but that wasn't a valid input.");
	}

	
	
	
	
	//AUTHENTICATION & REGISTRATION DISPLAY METHODS

	@Override
	public User displayLogin() {
		this.u = new User();
		Authenticate auth = new AuthenticateImpl();
		boolean checkingUserName = true;
			do { 
			System.out.println("Please login to continue.");
			System.out.println("Enter your username now:");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();
			if(!auth.validUser(username)) {
				System.out.println("Sorry, that's not a valid username. Please try again.");
				break;
			} else { 
				this.u.setUserName(username);
				checkingUserName = false; }
			} while (checkingUserName); 
		
		boolean checkingPass = true;
		do {
			System.out.println("Now enter your password:");
			Scanner sc2 = new Scanner(System.in);
			String password = sc2.nextLine();
			sc2.close();
			String username = this.u.getUserName();
			if(!auth.validUserAndPass(username,password)) {
				System.out.println("Sorry, that password is incorrect. Please try again.");
			} else { checkingPass = false;
				this.u = auth.getUser(username);}
				return u;
			} while(checkingPass);
			} 

			
	
	
	

	@Override
	public void displayRegisterNewUser() {
		boolean registering = true; //do I also need to set this.user=null;
		RegisterUser x = new RegisterUserImpl();
		while(registering) { 
			System.out.println("Please enter a username for your new account.");
			System.out.println("Enter your username now:");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();
			if(x.checkUsername(username)) {
				System.out.println("Sorry, but that username is taken.");
				System.out.println("Please try again.");
			} else { registering = false; }
			
				boolean matching = true;
				while(matching) {
					System.out.println("Please enter a new password:");
					String pass = sc.nextLine();
					System.out.println("Please re-enter your password:");
					String pass2 = sc.nextLine();
					if(!pass.equals(pass2)) {
						System.out.println("Sorry but those passwords don't match.");
						System.out.println("Please try again.");
					} else {
						System.out.println("Are you registering as an employee? Type yes or no.");
						String isEmp = sc.nextLine();
						if(isEmp == "yes") {
						x.registerNewUser(username, pass, true);
						matching = false;
					} else { x.registerNewUser(username, pass, false); }
					}					
					}
					}
		}

	
	


	
	
	
	
	//MENU DISPLAY METHODS
	@Override
	public void displayStart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tyler's Banking Simulation!");
		this.currentMenu = "start menu.";
		this.sayHeader();
		super.displayStart();
			String choice = sc.nextLine();
					switch(choice) {
					case "1": displayCust();
						break;
					case "2": displayNewUser();
						break;
					case "3": displayEmpMenu();
						break;
					default: saySorry();
						break;
					} sc.close();
	}

	
	@Override
	public User displayCust() { //do I want to return a User or accept as arg? //same for emp?
		this.displayLogin();
		CustDAO c = new CustDAOImpl();
		this.currentMenu = "account menu for existing customers.";
		this.sayHeader();
		super.menuCust();
			Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine();
					switch(choice) {
					case "1": c.mkAccount();//existing cust register for new acct
						break;
					case "2": c.viewAccounts();//view my account balances
						break;					//Ben's todo had println(u.getToDoList());
					case "3": c.viewTransactions();//view transactions 
						break;
					case "4": c.mkDeposit();// make a deposit
						break;
					case "5": c.mkWithdraw(); // make a withdrawal
						break;
					case "6": c.mkTransfer();// transfer between my accounts
						break;
					case "7": c.mkTransferOut();// transfer to another user
						break;
					case "0": //exit and start over
						displayStart();
						break;
					default: saySorry();
					} sc.close();
					return this.u;
	}
	
	

	@Override
	public void displayNewUser() { //I'm wondering about the return types. User or void?
		
		this.currentMenu = "registration menu for all new users.";
		this.sayHeader();
		displayRegisterNewUser();
		System.out.println("Now use your new credentials to login.");
		displayLogin();
	}
	
	

	
	
	
	@Override
	public User displayEmpMenu() { //or should it return an EmpDAO?
		this.displayLogin();
		EmpDAO e = new EmpDAOImpl();
		this.currentMenu = "employee main menu.";
		this.sayHeader();
		super.menuEmp();
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
			switch(choice) {
			case "1": e.viewAll();//view all customer accounts
				break;
			case "2": 
				System.out.println("Enter the username you want to search:");
				String cust = sc.nextLine();
				e.viewByName(cust);//search accounts by customer name
				break;
			case "3": 
				System.out.println("Enter the username of the pending account you want to approve.");
				e.approvePending();//approve pending accounts
				break;
			case "4": 
				System.out.println("Enter the username of the pending account you want to reject.");
				e.approvePending();//approve pending accounts
				break;
			case "5": e.viewLog();// view the transaction log
				break;
			case "0":
				displayStart();
				break;
			default: saySorry();
			} sc.close();
			return this.u;
	} 
	
}
