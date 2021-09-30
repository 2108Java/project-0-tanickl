package com.revature.tan.presentation;

import com.revature.tan.*;
import com.revature.tan.models.Account;
import com.revature.tan.models.User;
import com.revature.tan.repo.CustDAO;
import com.revature.tan.repo.EmpDAO;
import com.revature.tan.repo.UserDAO;
import com.revature.tan.service.Authenticate;
import com.revature.tan.service.AuthenticateImpl;
import com.revature.tan.service.ConnectionMaker;
import com.revature.tan.service.CustDAOImpl;
import com.revature.tan.service.EmpDAOImpl;
import com.revature.tan.service.RegisterUser;
import com.revature.tan.service.RegisterUserImpl;
import com.revature.tan.service.UserDAOImpl;

import java.sql.Connection;
import java.util.Scanner;

public class DisplaysImpl extends AbstractDisplays implements Displays {

	//FIELDS
	private String currentMenu;
	private User u = new User(); 
	
	
	//CONSTRUCTORS
	public DisplaysImpl(User u) { 
		this.u = u; 
	}							  
	
	public DisplaysImpl() {
		this.u = new User();

	}
	
	
	
	//MISC METHODS
	private void sayHeader() {
		System.out.println("You are now viewing the " + this.currentMenu);
	}

	
	
	private void saySorry() { //add this to catch blocks
		System.out.println("Sorry, but either that wasn't a valid input or something else went wrong.");
	}

	
	//METHODS IN ORDER PRESENTED TO USER
	
	@Override
	public void displayStart() {
//		this.u = new User(); //to reset user after session, starting over
		super.displaySpace();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tyler's Banking Simulation!");
		this.currentMenu = "start menu.";
		this.sayHeader();
		super.displayStart();
			String choice = sc.nextLine();
					switch(choice) {
					case "1": displayLogin();
						break;
					case "2": displayNewUser();
						break;
					default: saySorry();
					} displayStart();
	}
	
	
	
	//AUTHENTICATION & REGISTRATION DISPLAY METHODS

	@Override
	public User displayLogin() { //I could also return DisplayImpl objs and pass in User arg, if buggy
		super.displaySpace();
		Authenticate auth = new AuthenticateImpl();
		UserDAO uDAO = new UserDAOImpl();
		//checks username
		boolean checkingUserName = true;
			do { 
				System.out.println("Please login to continue.");
				System.out.println("Enter your username now:");
				Scanner sc = new Scanner(System.in); //if mult scanners is trouble, try moving into MainDriver
				String username = sc.nextLine();
				if(!auth.validUser(username)) {
					System.out.println("Sorry, that's not a valid username. Please try again.");
				} else { 
					this.u.setUserName(username);
					checkingUserName = false; }
				} while (checkingUserName); 
		
		//checks password
		boolean checkingPass = true;
			do {
				System.out.println("Now enter your password:");
				Scanner sc2 = new Scanner(System.in);
				String password = sc2.nextLine();
				String username = this.u.getUserName(); 
				if(!auth.validUserAndPass(username,password)) {
					System.out.println("Sorry, that password is incorrect. Please try again.");
				} else { this.u.setUserPass(password);
					checkingPass = false; 	}
				} while(checkingPass);
					
		//finishes up, calls next display
			this.u = uDAO.getUser(u);
				System.out.println("Thanks for logging in, " + u.getUserName() + ".");
				System.out.println("Your user_id is " + u.getUserId());				
				System.out.println("Your user_id is " + this.u.getUserId());
				Displays next = new DisplaysImpl(this.u);
					if(u.getIsEmp()) {next.displayEmpMenu(u); }
					else { next.displayCust(this.u); }
					return u;
	}


	
	@Override
	public void displayNewUser() {
		super.displaySpace();
		this.currentMenu = "registration menu for all new users.";
		this.sayHeader();
		displayRegisterNewUser();
		System.out.println("Now use your new credentials to login.");
		displayLogin();
	}
	

	@Override
	public void displayRegisterNewUser() {
		super.displaySpace();
		String username = this.u.getUserName();
		String pass = this.u.getUserPass();
		RegisterUser x = new RegisterUserImpl();
		
		//testing if I have the default user
		System.out.println("Right now, the user is " + username
				+ " and the password is " + pass);
		System.out.println(u.toString());
				
		//registers a unique username for new user
		boolean registering = true;
			do { 
				System.out.println("Please enter a username for your new account.");
				System.out.println("Enter your username now:");
				Scanner sc = new Scanner(System.in);
				username = sc.nextLine();
				if(!x.checkUsername(username)) {
					System.out.println("Sorry, but that username is taken.");
					System.out.println("Please try again.");
				} else { registering = false; } 
			} while(registering);
		
		//customer enters and confirms a new password
			boolean matching = true;
				do {
					Scanner sc = new Scanner(System.in); //might need to close either scanner
					System.out.println("Please enter a new password:");
					pass = sc.nextLine();
					System.out.println("Please re-enter your password:");
					String pass2 = sc.nextLine();
					if(!pass.equals(pass2)) {
						System.out.println("Sorry, but those passwords don't match.");
						System.out.println("Please try again.");
					} else {
						System.out.println("Are you registering as an employee? Type 1 for yes or 2 for no.");
						if(sc.nextInt() == 1) { this.u.setIsEmp(true);
						} else { this.u.setIsEmp(false); }
//						sc.nextInt();
						this.u.setUserName(username);
						this.u.setUserPass(pass2);
//						x.registerNewUser(username, pass, isEmp);
						x.registerNewUser(this.u);
						matching = false; } 
				} while(matching); 
				displayLogin();
	}
					
	
		

	
	
	
	
	//MENU DISPLAY METHODS

	
	@Override
	public User displayCust(User u) {
		this.u = u;
		super.displaySpace();
		this.currentMenu = "account menu for existing customers.";
		this.sayHeader();
			System.out.println("Welcome, " + u.getUserName() + ".");//including this as a test for how user is passed between display methods
			System.out.println("Your user_id is " + u.getUserId());
			super.menuCust();
		System.out.println("Choose from the options that follow.");	
		Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			switch(choice) {
				case "1": //new savings or checking account 
						System.out.println("Hello, " + this.u.getUserName() + ".");
						System.out.println("Your user_id is " + u.getUserId());
						System.out.println("Enter 1 to begin a new SAVINGS account.");
						System.out.println("Enter 2 to begin a new CHECKING account.");
						Account a = new Account(this.u); //constructor implies user_id foreign key
						CustDAO c1 = new CustDAOImpl();
						int which = sc.nextInt();
							if(which == 1) { 
								a.setAcctType("savings"); 
								} 
							if(which == 2) {
								a.setAcctType("checking");
							} 
							System.out.println("How much will you deposit for your starting balance?");
							double x = sc.nextDouble();
								a.setBalance(x);
							c1.mkAccount(a, this.u);
						System.out.println("Returning to " + this.currentMenu);
							displayCust(this.u);
						break;
					
					//view accounts and balances
					case "2": 
						System.out.println("Hello, " + this.u.getUserName() + ".");
						System.out.println("Here is the current data for all your accounts:");
						CustDAO c2 = new CustDAOImpl();
						c2.viewAccounts(u);
						
						System.out.println("Returning to " + this.currentMenu);
						displayCust(this.u);
						break;					
					
					//view transactions
					case "3": 
						System.out.println("Hello, " + this.u.getUserName() + ".");
						System.out.println("Here are your transactions:");
						
						CustDAO c3 = new CustDAOImpl();
						c3.viewTransactions(u);
						
						System.out.println("Returning to " + this.currentMenu);
						displayCust(this.u);
						break;
					
					
					//make a deposit
					case "4": 
						System.out.println("Hello, " + this.u.getUserName() + ".");
						CustDAO c4 = new CustDAOImpl();
						c4.mkDeposit(u);						
						System.out.println("Returning to " + this.currentMenu);
						displayCust(this.u);
						break;
					
						
					//withdraw 
					case "5": 
						System.out.println("Here is a list of your current accounts:");
						CustDAO c5 = new CustDAOImpl();
						c5.mkWithdraw(this.u);
						System.out.println("Returning to " + this.currentMenu);
						displayCust(this.u);
						break;
					
					//make a transfer
					case "6": 
						System.out.println("Here is a list of your current accounts:");
						CustDAO c6 = new CustDAOImpl();
						c6.mkTransfer(u);
						System.out.println("Returning to " + this.currentMenu);
						displayCust(this.u);
						break;
					
					//make transfer to other user
					case "7": 
						System.out.println("Ok, let's make an outside transfer.");
						CustDAO c7 = new CustDAOImpl();
						c7.mkTransferOut(this.u);
						System.out.println("Returning to " + this.currentMenu);
						displayCust(this.u);
						break;
					
					case "0": //exit and start over
						displayStart();
						break;
					default: saySorry();
					this.displayCust(this.u);
			}
					return this.displayCust(this.u);
	}
	
	


	
	

	public User displayEmpMenu(User u) {
		super.displaySpace();
		EmpDAO e = new EmpDAOImpl();
		this.currentMenu = "employee main menu.";
		this.sayHeader();
		super.menuEmp();
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			System.out.println("Welcome, " + u.getUserName());//including this as a test for how user is passed between display methods
			

			switch(choice) {
			
			
			case "1":			//view all accounts
				System.out.println("Hello, " + this.u.getUserName() + ".");
				System.out.println("Here is the current data for ALL CUSTOMER accounts:");
				EmpDAO e1 = new EmpDAOImpl();
				e1.viewAll();
				System.out.println("Returning to " + this.currentMenu);
				break;
			
			case "2":			//view customer list
				System.out.println("Hello, " + this.u.getUserName() + ".");
				System.out.println("Here is the bank's current customer list: ");
				EmpDAO ee = new EmpDAOImpl();
				ee.viewCustRoll();
				System.out.println("Returning to " + this.currentMenu);
				break;
				
			case "3":			//search accts by username
				System.out.println("Enter the username you want to search:");
				String cust = sc.nextLine();
				EmpDAO e2 = new EmpDAOImpl();
				e2.viewByName(cust);//search accounts by customer name
				break;
			
			
			case "4":			//approve a pending account
				System.out.println("Here are all the pending accounts:");
				EmpDAO e3 = new EmpDAOImpl();
				e3.selectPending();
				System.out.println("Enter the account number of the pending account you want to approve.");
				int cust3 = sc.nextInt();
				e3.approvePending(cust3);
				break;
			
			case "5": 			//reject a pending
				System.out.println("Here are all the pending accounts:");
				EmpDAO e4 = new EmpDAOImpl();
				e4.selectPending();
				System.out.println("Enter the account number of the pending account you want to reject.");
				int cust4 = sc.nextInt();
				e4.rejectPending(cust4);//approve pending accounts
				break;
			
			case "6": 			//view the transaction log
				System.out.println("Here is the transaction log:");
				EmpDAO e5 = new EmpDAOImpl();
				e5.viewLog();
				break;
			
			case "0":
				displayStart();
				break;
			default: saySorry();
			}
			this.displayEmpMenu(u);
			return this.u;
	} 
	
}
