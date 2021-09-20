package com.revature.tan.presentation;

import com.revature.tan.*;
import com.revature.tan.models.Customer;
import com.revature.tan.models.Employee;
import com.revature.tan.models.User;
import com.revature.tan.service.Authenticate;
import com.revature.tan.service.AuthenticateImpl;
import com.revature.tan.service.RegisterUser;
import com.revature.tan.service.RegisterUserImpl;

import java.util.Scanner;

public class DisplaysImpl extends AbstractDisplays implements Displays {

	//FIELDS
	private String lastMenu;
	private String currentMenu;
	private User user;
	
	
	//CONSTRUCTORS
	public DisplaysImpl() {
	}
	
	public DisplaysImpl(User user) { //use when invoking next display?
		this.user = user;
	}
	
	private void sayHeader() {
		System.out.println("You are now viewing the " + this.currentMenu);
	}
	
	
	private void sayFooter() {
		System.out.println("Enter '0' to return to the " + this.lastMenu);
	}
	
	
	private void saySorry() {
		System.out.println("Sorry, but that wasn't a valid input.");
	}

	
	//AUTHENTICATION & REGISTRATION DISPLAY METHODS

	@Override
	public User displayLogin() {
		boolean loggingIn = true;
		Authenticate auth = new AuthenticateImpl();
		while(loggingIn) { 
			System.out.println("Please login to continue.");
			System.out.println("Enter your username now:");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();
			System.out.println("Now enter your password:");
			String password = sc.nextLine();
			boolean isValid = auth.validUser(username,password);
			if(isValid) {
				this.user = auth.getUser(username);
				return user;
				} else {
					System.out.println("Sorry, but either your username or password was incorrect.");
					System.out.println("Please try again.");
			}
		} 
	}
	
	
	


	@Override
	public User displayRegisterUsername() {
		boolean registered = false; //do I also need to set this.user=null;
		RegisterUser x = new RegisterUserImpl();
		while(!(registered)) { 
			System.out.println("Please enter a username for your new account.");
			System.out.println("Enter your username now:");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();
			boolean	isUnique = x.checkUsername(username);
				if(isUnique) {
					this.user = x.registerUsername(username);
					registered = true;
					return this.user;
				} else {
					System.out.println("Sorry, but that username is taken.");
					System.out.println("Please try again.");
				} return this.user;
		}
	}
	
	


	@Override
	public User displayNewUserPass() {
		boolean matched = false;
		RegisterUser x = new RegisterUserImpl();
		while(!(matched)) {
			System.out.println("Please enter a new password:");
			Scanner sc = new Scanner(System.in);
			String pass = sc.nextLine();
			System.out.println("Please re-enter your password:");
			String pass2 = sc.nextLine();
			
			boolean	isMatching = x.checkPassMatch(pass,pass2);
			if(isMatching) {
				x.registerPassword(this.user, pass);
				matched = true;
			} else {
				System.out.println("Sorry, but those passwords don't match.");
				System.out.println("Please try again.");
			} return this.user;
		}
	}
	
	
	
	
	//MENU DISPLAY METHODS
	@Override
	public void displayStart() {
		this.user = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tyler's Banking Simulation!");
		this.lastMenu = null;
		this.currentMenu = "start menu.";
		this.sayHeader();
		//this.sayFooter(); IS NULL for START MENU
		super.displayStart();
			String choice = sc.nextLine();
					switch(choice) {
					case "1": displayCust();
						break;
					case "2": displayNewCust();
						break;
					case "3": displayEmpMenu();
						break;
					case "4": displayNewEmp();
					default: saySorry();
						break;
					} 
	}

	



	@Override
	public User displayCust() { //do I want to return a User or accept as arg? //same for emp?
		displayLogin();
		Customer c = (Customer) this.user;
		this.currentMenu = "account menu for existing customers.";
		this.sayHeader();
		//this.sayFooter();
		super.menuCust();
			Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine();
					switch(choice) {
					case "1": c.mkAccount();//existing cust register for new acct
						break;
					case "2": c.viewAccounts();//view my account balances
						break;
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
					case "8": c.mkJoint(); // authorize a jointuser
						break;
					case "0": //exit and start over
						this.user = null;
						displayStart();
						break;
					default: saySorry();
					} return this.user;
	}
	
	

	@Override
	public void displayNewCust() { //I'm wondering about the return types. User or void?
		this.user = new Customer();
		this.currentMenu = "registration menu for new customers.";
		this.sayHeader();
		displayRegisterUsername();
		displayNewUserPass();
		System.out.println("Now use your new credentials to login.");
		displayCust();
	}
	
	
	@Override
	public void displayNewEmp() {
		this.user = new Employee();
		this.currentMenu = "new employee set-up menu.";
		this.sayHeader();
		displayRegisterUsername();
		displayNewUserPass();
		System.out.println("Now use your new credentials to login.");
		displayEmpMenu();
	}
	
	
	@Override
	public User displayEmpMenu() {
		displayLogin();
		Employee e = (Employee) this.user;
		this.currentMenu = "employee main menu.";
		this.sayHeader();
		//this.sayFooter();
		super.menuEmp();
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
			switch(choice) {
			case "1": e.viewAll();//view all customer accounts
				break;
			case "2": e.viewByName();//search accounts by customer name
				break;
			case "3": e.approvePending();//approve pending accounts
				break;
			case "4": e.viewLog();// view the transaction log
				break;
			case "0":
				this.user = null;
				displayStart();
				break;
			default: saySorry();
			}	
	}
	

}
