package com.revature.tan.presentation;

import com.revature.tan.*;
import com.revature.tan.models.Account;
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
	private User u = new User();
	
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
		Authenticate auth = new AuthenticateImpl();
		boolean checkingUserName = true;
			do { 
				System.out.println("Please login to continue.");
				System.out.println("Enter your username now:");
				Scanner sc = new Scanner(System.in);
				String username = sc.nextLine();
				if(!auth.validUser(username)) {
					System.out.println("Sorry, that's not a valid username. Please try again.");
				} else { 
					this.u.setUserName(username);
					checkingUserName = false; }
				} while (checkingUserName); 
		
		boolean checkingPass = true;
			do {
				System.out.println("Now enter your password:");
				Scanner sc2 = new Scanner(System.in);
				String password = sc2.nextLine();
//				sc2.close();
				String username = this.u.getUserName();
				if(!auth.validUserAndPass(username,password)) {
					System.out.println("Sorry, that password is incorrect. Please try again.");
				} else { this.u.setUserPass(password);
					checkingPass = false; 	}
				}
				while(checkingPass);
				
				System.out.println("Thanks for logging in.");
				Displays next = new DisplaysImpl();
				if(u.getIsEmp()) {next.displayEmpMenu(this.u); }
				else { next.displayCust(this.u); }
				return u;
	}


	
	

	@Override
	public void displayRegisterNewUser() {
		User u2;
		String username;
		String pass;
		boolean registering = true; //do I also need to set this.user=null;
		RegisterUser x = new RegisterUserImpl();
		
		while(registering) { 
			System.out.println("Please enter a username for your new account.");
			System.out.println("Enter your username now:");
			Scanner sc = new Scanner(System.in);
			username = sc.nextLine();
			if(x.checkUsername(username)) {
				System.out.println("Sorry, but that username is taken.");
				System.out.println("Please try again.");
			} else { registering = false; }
			
			boolean matching = true;
				while(matching) {
					System.out.println("Please enter a new password:");
					pass = sc.nextLine();
					System.out.println("Please re-enter your password:");
					String pass2 = sc.nextLine();
					if(!pass.equals(pass2)) {
						System.out.println("Sorry but those passwords don't match.");
						System.out.println("Please try again.");
					} else {
						System.out.println("Are you registering as an employee? Type yes or no.");
						String yesno = sc.nextLine();
						boolean isEmp = (yesno == "yes"); 
						x.registerNewUser(username, pass, isEmp);
						matching = false; }
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
					case "1": displayLogin();
						break;
					case "2": displayNewUser();
						break;
					default: saySorry();
						break;
					} sc.close();
	}

	
	@Override
	public User displayCust(User u) {
		Account a = new Account(this.u.getUserId());
		CustDAO c = new CustDAOImpl();
		this.currentMenu = "account menu for existing customers.";
		this.sayHeader();
		super.menuCust();
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			System.out.println("Choose from the options that follow.");
					switch(choice) {
					case "1": 
						
						System.out.println("Hello" + this.u.getUserName() + ".");
						System.out.println("Enter 1 to begin a new SAVINGS account.");
						System.out.println("Enter 2 to begin a new CHECKING account.");
						String which = sc.nextLine();
							if(which == "1") { 
								a.setAcctType("savings");	
								} 
							if(which == "2") {
								a.setAcctType("checking");
							} 
							System.out.println("How much will you deposit for your starting balance?");
							double x = sc.nextDouble();
							a.setBalance(x);
							c.mkAccount(a);
						break;
					case "2": 
						System.out.println("Here is the current data for all your accounts:");
						c.viewAccounts(a);//view my account balances
						break;					//Ben's todo had println(u.getToDoList());
//					case 3: 
//						
//						c.viewTransactions();//view transactions 
//						break;
					case "4": 
						System.out.println("Here is a list of your current accounts:");
						c.viewAccounts(a);
						System.out.println("Enter the account number to which you'll deposit:");
						a.setUserForKey(sc.nextInt());
						System.out.println("Enter the amount to DEPOSIT:");
						double y = sc.nextDouble();
						c.mkDeposit(a, y);// make a deposit
						break;
					case "5": 
						System.out.println("Here is a list of your current accounts:");
						c.viewAccounts(a);
						System.out.println("Enter the account number from which you'll withdraw:");
						a.setUserForKey(sc.nextInt());
						System.out.println("Enter the amount to WITHDRAW:");
						double z = sc.nextDouble();
						c.mkWithdraw(a, z); // make a withdrawal
						break;
					case "6": 
						
						c.mkTransfer();// transfer between my accounts
						break;
					case "7": 
						
						c.mkTransferOut();// transfer to another user
						break;
					case "0": //exit and start over
						displayStart();
						break;
					default: saySorry();
//					String choice = sc.nextLine();
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
	@Override
	public User displayEmpMenu(User u) { //or should it return an EmpDAO?
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
