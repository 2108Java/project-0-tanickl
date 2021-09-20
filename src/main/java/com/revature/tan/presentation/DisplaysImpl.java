package com.revature.tan.presentation;
package com.revature.tan.service;

import com.revature.tan.service.Authenticate;
import com.revature.tan.service.AuthenticateImpl;
import com.revature.tan.service.RegisterUser;
import com.revature.tan.service.RegisterUserImpl;

import java.util.Scanner;

public class DisplaysImpl extends AbstractDisplays implements Displays {

	//FIELDS
	private String lastMenu;
	private String currentMenu;
	private String nextMenu;

	
	//CONSTRUCTOR
	public DisplaysImpl() {
		// TODO Auto-generated constructor stub
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

	
	//INTERFACE METHODS

	@Override
	public boolean displayLogin() {
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
				return loggingIn = false;
				} else {
					System.out.println("Sorry, but either your username or password was incorrect.");
					System.out.println("Please try again.");
			}
		} 
	}
	
	
	

	@Override
	public boolean displayRegisterUsername() {
		boolean registered = false;
		RegisterUser x = new RegisterUserImpl();
		while(!(registered)) { 
			System.out.println("Please enter a username for your new account.");
			System.out.println("Enter your username now:");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();
			boolean	isUnique = x.checkUsername(username);
				if(isUnique) {
					x.registerUsername(username);
					registered = true;
				} else {
					System.out.println("Sorry, but that username is taken.");
					System.out.println("Please try again.");
				} return registered;
		}
	}
	
	

	@Override
	public boolean displayPassMatch() {
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
				x.registerPassword(pass);
				matched = true;
			} else {
				System.out.println("Sorry, but those passwords don't match.");
				System.out.println("Please try again.");
			} return matched;
		}
	}
	
	
	
	@Override
	public void displayStart() { //need to change return to update lastMenu string?
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tyler's Banking Simulation!");
		this.lastMenu = null;
		this.currentMenu = "start menu.";
		this.sayHeader();
		//this.sayFooter(); IS NULL for START MENU
		super.displayStart();
			String choice = sc.nextLine(); //1 displayCust; 2 displayNewCust; 3 EmpPort
					switch(choice) {
					case "1": displayCust();
						break;
					case "2": displayNewCust();
						break;
					case "3": displayEmpPortal();
						break;
					//case "0": BC LAST MENU IS NULL
//						break;
					default: saySorry();
						break;
					} 
		this.currentMenu = this.lastMenu;
	}

	
	@Override
	public void displayCust() {
		displayLogin();
		this.currentMenu = "account menu for existing customers.";
		this.sayHeader();
		this.sayFooter();
		super.displayCust();
			Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine();
					switch(choice) {
					case "1": 
						break;
					case "2": 
						break;
					case "3": 
						break;
					//case "0": BC LAST MENU IS NULL
			//			break;
					default: saySorry();
						break;
		} 	
		//LOGIC
				//existing register for new acct
				//joint account // add a user to existing account
				//view balance of acct
				//make deposit or withdrawal between my accounts
				//accept money transfer from another acct
				//view transactions
		this.currentMenu = this.lastMenu;
	}
	
	
	@Override
	public void displayNewCust() {
		this.currentMenu = "registration menu for new customers.";
		this.sayHeader();
		this.sayFooter();
		super.displayNewCust();
			//then the logic
		this.currentMenu = this.lastMenu;
	}
	
	
	@Override
	public void displayEmpPortal() {
		this.currentMenu = "employee portal.";
		this.sayHeader();
		this.sayFooter();
		super.displayEmpPortal();
			//then the logic
		this.currentMenu = this.lastMenu;
		
	}
	
	@Override
	public void displayEmpNew() {
		this.currentMenu = "new employee setup menu.";
		this.sayHeader();
		this.sayFooter();
		super.displayEmpNew();
			//then the logic
		this.currentMenu = this.lastMenu;
	}
	
	@Override
	public void displayEmpMain() {
		this.currentMenu = "employee main menu.";
		this.sayHeader();
		this.sayFooter();
		super.displayEmpMain();
			//then the logic
		this.currentMenu = this.lastMenu;
//		•As an employee, I can approve or reject an account registration by a user.* 2 points
//		•As an employee, I can view a customer's bank accounts.* 1 point
//		I can view transaction log		
	}
	
}
