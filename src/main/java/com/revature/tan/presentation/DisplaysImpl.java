package com.revature.tan.presentation;

import com.revature.tan.*;
import com.revature.tan.models.Customer;
import com.revature.tan.models.Employee;
import com.revature.tan.models.User;
import com.revature.tan.repo.CustomerDAO;
import com.revature.tan.repo.EmpDAO;
import com.revature.tan.service.Authenticate;
import com.revature.tan.service.AuthenticateImpl;
import com.revature.tan.service.RegisterUser;
import com.revature.tan.service.RegisterUserImpl;

import java.util.Scanner;

public class DisplaysImpl extends AbstractDisplays implements Displays {

	//FIELDS
	private String currentMenu;
	private User user;
	//private Scanner sc;
	
	
	//CONSTRUCTORS
	public DisplaysImpl() {
	}
	
	public DisplaysImpl(User user) { //use when invoking next display?
		this.user = user;
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
		while(checkingUserName) { 
			System.out.println("Please login to continue.");
			System.out.println("Enter your username now:");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();
			if(!auth.validUser(username)) {
				System.out.println("Sorry, that's not a valid username. Please try again.");
			} else { checkingUserName = false; }
		
		boolean checkingPass = true;
		while(checkingPass) {
			System.out.println("Now enter your password:");
			String password = sc.nextLine();
			sc.close();
			if(!auth.validUserAndPass(username,password)) {
				System.out.println("Sorry, that password is incorrect. Please try again.");
			} else { checkingPass = false;
				this.user = auth.getUser(username);
			} return user;
			}
			}
		return user;
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
			if(!x.checkUsername(username)) {
				System.out.println("Sorry, but that username is taken.");
				System.out.println("Please try again.");
			} else { registering = false; }
			
				boolean matching = true;
				while(matching) {
					System.out.println("Please enter a new password:");
					String pass = sc.nextLine();
					System.out.println("Please re-enter your password:");
					String pass2 = sc.nextLine();
					sc.close();
					if(pass.equals(pass2)) {
						this.user.setUserPass(pass);
						this.user.setUserName(username);
						x.registerNewUser(username, pass);
						matching = false;
					} else {
						System.out.println("Sorry, but those passwords don't match.");
						System.out.println("Please try again.");
					} 
				}
			}
	}	

	
	


	
	
	
	
	//MENU DISPLAY METHODS
	@Override
	public void displayStart() {
		this.user = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tyler's Banking Simulation!");
		this.currentMenu = "start menu.";
		this.sayHeader();
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
					} sc.close();
	}

	
//I might also want to overload this method and provide a parameterized constructor 
	//so that the DAO interface can call the same display
	//are do I actually want some of these methods to return a display?
	//Ben had his ToDo methods ACCEPT User as arg.
	@Override
	public User displayCust() { //do I want to return a User or accept as arg? //same for emp?
		displayLogin();
		CustomerDAO c = (Customer) this.user;
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
					case "8": c.mkJoint(); // authorize a jointuser
						break;
					case "0": //exit and start over
						this.user = null;
						displayStart();
						break;
					default: saySorry();
					} sc.close();
					return this.user;
	}
	
	

	@Override
	public void displayNewCust() { //I'm wondering about the return types. User or void?
		this.user = new Customer();
		this.currentMenu = "registration menu for new customers.";
		this.sayHeader();
		displayRegisterNewUser();
		System.out.println("Now use your new credentials to login.");
		displayCust();
	}
	
	
	
	@Override
	public void displayNewEmp() {
		this.user = new Employee();
		this.currentMenu = "new employee set-up menu.";
		this.sayHeader();
		displayRegisterNewUser();
		System.out.println("Now use your new credentials to login.");
		displayEmpMenu();
	}
	
	
	
	@Override
	public User displayEmpMenu() { //or should it return an EmpDAO?
		displayLogin();
		EmpDAO e = (Employee) this.user;
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
			} sc.close();
			return e;	
	}
	

}
