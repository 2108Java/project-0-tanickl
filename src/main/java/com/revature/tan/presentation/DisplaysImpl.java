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
	public Connection connection = ConnectionMaker.getConnection();
								//right now, I'm instantiating a new User at login
								
								//and then passing that user around to the different
								 //methods below
								 //But I might not even need to do that. Could just keep using
								 //the same user object that belongs to this DisplayImpl object
								 //as the diff methods get invoked.
	
	
	
	//CONSTRUCTORS
	public DisplaysImpl(User u) { //This constructor will allow me to pass User objects to the next display
		this.u = u;
//		this.connection = ConnectionMaker.getConnection();
								//It shouldn't be a problem for User objects the no-arg constr makes 
	}							  //"undefined" username and password should show how its working
	
	public DisplaysImpl() {
		this.u = new User();
//		this.connection = ConnectionMaker.getConnection();
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
						break;
					} sc.close();
	}
	
	
	
	//AUTHENTICATION & REGISTRATION DISPLAY METHODS

	@Override
	public User displayLogin() { //I could also return DisplayImpl objs and pass in User arg, if buggy
		Authenticate auth = new AuthenticateImpl();
		
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
				String username = this.u.getUserName(); //could also try moving this up
				if(!auth.validUserAndPass(username,password)) {
					System.out.println("Sorry, that password is incorrect. Please try again.");
				} else { this.u.setUserPass(password);
					checkingPass = false; 	}
				} while(checkingPass);
					
		//finishes up, calls next display
				System.out.println("Thanks for logging in.");
				Displays next = new DisplaysImpl(this.u);//should be ok, but see comment on method sig line 
					if(u.getIsEmp()) {next.displayEmpMenu(u); }
					else { next.displayCust(this.u); }
					return u;  //especially if this return type gets annoying
							   //encapsulation might be best achieved by display types having user fields, users having accounts, accounts...
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
	public void displayRegisterNewUser() {
		//User u2; //should not need to do this now that I am using the constructor
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
				if(x.checkUsername(username)) {
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
						System.out.println("Are you registering as an employee? Type yes or no.");
						String yesno = sc.nextLine();
						boolean isEmp = (yesno.toString().equals("yes"));
						this.u.setUserName(username);
						this.u.setUserPass(pass2);
						this.u.setIsEmp(isEmp);
//						x.registerNewUser(username, pass, isEmp);
						x.registerNewUser(this.u);
						matching = false; } 
				} while(matching);
	}
					
	
		

	
	
	
	
	//MENU DISPLAY METHODS

	
	@Override
	public User displayCust(User u) {
		CustDAO c = new CustDAOImpl();
		UserDAO ud = new UserDAOImpl();
		User uu = ud.getUser(this.u.getUserName());
		this.currentMenu = "account menu for existing customers.";
		this.sayHeader();
			System.out.println("Welcome, " + u.getUserName());//including this as a test for how user is passed between display methods
		super.menuCust();
		System.out.println("Choose from the options that follow.");	
		Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			
					
			switch(choice) {
					
					//new savings or checking account
					case "1": 
						System.out.println("Hello" + this.u.getUserName() + ".");
						System.out.println("Enter 1 to begin a new SAVINGS account.");
						System.out.println("Enter 2 to begin a new CHECKING account.");
						Account a = new Account(this.u);
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
							c.mkAccount(a);
						break;
					
					//view accounts and balances
					case "2": 
						System.out.println("Here is the current data for all your accounts:");
					
						c.viewAccounts(uu);
						break;					
					
					//view transactions
					case "3": 
						System.out.println("Here are your transactions:");
//						UserDAO uDAO2 = new UserDAOImpl();
						c.viewTransactions(uu);
						break;
					
					
					//make a deposit
					case "4": 
						System.out.println("Here is a list of your current accounts:");
						c.viewAccounts(uu);
						System.out.println("Enter the account number to which you'll deposit:");
						Account aa = new Account(this.u);
						aa.setUserForKey(sc.nextInt());
						System.out.println("Enter the amount to DEPOSIT:");
						double y = sc.nextDouble();
						c.mkDeposit(aa, y);// make a deposit
						break;
					
						
					//withdraw 
					case "5": 
						System.out.println("Here is a list of your current accounts:");
						c.viewAccounts(uu);
						System.out.println("Enter the account number from which you'll withdraw:");
						Account aaa = new Account(uu);
						aaa.setUserForKey(sc.nextInt());
						System.out.println("Enter the amount to WITHDRAW:");
						double z = sc.nextDouble();
						c.mkWithdraw(aaa, z); // make a withdrawal
						break;
					
					//make a transfer
					case "6": 
						System.out.println("Here is a list of your current accounts:");
						c.viewAccounts(uu);
						System.out.println("Enter the account number you will DEBIT:");
						int debit = sc.nextInt();
						System.out.println("Enter the account number you will CREDIT:");
						int credit = sc.nextInt();
						System.out.println("Enter the amount you wish to transfer:");
						double amt = sc.nextDouble();
						c.mkTransfer(debit, credit, amt); 
						break;
					
					//make transfer to other user
					case "7": 
						System.out.println("Here is a list of your current accounts:");
						c.viewAccounts(uu);
						System.out.println("Enter the account number of yours to DEBIT:");
						int tdebit = sc.nextInt();
						System.out.println("Enter the username of the account to CREDIT:");
						String trUser = sc.nextLine();
						System.out.println("Enter the amount you wish to transfer:");
						double amt2 = sc.nextDouble();
//						try { 
						c.mkTransferOut(tdebit, trUser, amt2);
						break;
					
					case "0": //exit and start over
						displayStart();
						break;
					default: saySorry();
//					String choice = sc.nextLine(); //unnecessary here
					} sc.close();
					uu = this.u;
					return this.displayCust(this.u); //want to see if this satisfies return requirement
	}
	
	


	
	

	public User displayEmpMenu(User u) {
		EmpDAO e = new EmpDAOImpl();
		this.currentMenu = "employee main menu.";
		this.sayHeader();
		super.menuEmp();
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			System.out.println("Welcome, " + u.getUserName());//including this as a test for how user is passed between display methods
			

			switch(choice) {
			
			
			case "1":			//view all customer accts 
				e.viewAll();
				break;
			case "2":			//search accts by username
				System.out.println("Enter the username you want to search:");
				String cust = sc.nextLine();
				e.viewByName(cust);//search accounts by customer name
				break;
			case "3":			//approve a pending account
				System.out.println("Here are all the pending accounts:");
				e.selectPending();
				System.out.println("Enter the username of the pending account you want to approve.");
				e.approvePending();
				break;
			case "4": 
				System.out.println("Here are all the pending accounts:");
				e.selectPending();
				System.out.println("Enter the username of the pending account you want to reject.");
				e.rejectPending();//approve pending accounts
				break;
			case "5": 			//view the transaction log
				System.out.println("Here is the transaction log:");
				e.viewLog(); 
				break;
			case "0":
				displayStart();
				break;
			default: saySorry();
			} sc.close();
			this.displayEmpMenu(u);
			return this.u;
	} 
	
}
