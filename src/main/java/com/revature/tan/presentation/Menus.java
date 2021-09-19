package com.revature.tan.presentation;

import java.util.Scanner;

public class Menus extends AbstractDisplays implements Displays {

	//FIELDS
	private String lastMenu;
	private String currentMenu;
	private String nextMenu;
	private Scanner sc = new Scanner(System.in);
	
	
	//CONSTRUCTOR
	public Menus() {
		// TODO Auto-generated constructor stub
	}
	

	//STANDARD MESSAGES // these are static methods for use inside and outside this class.
	public static void saySorry() {
		final String sorry = "Sorry, but that wasn't a valid input. Please try again.";
		System.out.println(sorry);
	}

	private static void askWhich() {
		final String which = "You've got some options. Which do you select?";
		System.out.println(which);
	}
	

	public static void askInput() {
		final String input = "We need your input for this next part.";
		System.out.println(input);
	}
	
	
	public static void sayWelcome() {
		final String welcome = "Welcome to Tyler's Banking Simulation!";
		System.out.println(welcome);
	}
	
	
	private void sayHeader() {
		System.out.println("You are now viewing the " + this.currentMenu);
	}
	
	
	private void sayFooter() {
		System.out.println("Enter '0' to return to the " + this.lastMenu);
	}
	
	

	//INTERFACE METHODS

	@Override
	public void displayStart() { //need to change return to update lastMenu string?
		this.lastMenu = null;
		this.currentMenu = "start menu.";
		this.sayHeader();
		//this.sayFooter(); IS NULL for START MENU
		super.displayStart();
			String choice = sc.nextLine(); //1 displayCust; 2 displayNewCust; 3 EmpPort
					switch (choice) {
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
		this.currentMenu = "account menu for existing customers.";
		this.sayHeader();
		this.sayFooter();
		super.displayCust();
			//then the logic
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
	}
	
}
