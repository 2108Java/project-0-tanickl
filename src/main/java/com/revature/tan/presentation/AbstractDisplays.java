package com.revature.tan.presentation;

import com.revature.tan.presentation.ConsoleSession;


//This abstract class handles my app's communication to the user by printing messages to the console.
//Because the menus and messages displayed in this app are very routine, the partial abstraction
//an abstract class provides allows me to store a lot of repetitive println statements here
//so that the bodies of extending subclasses are not cluttered with unnecessary overrides.



public abstract class AbstractDisplays {
		
	//NO FIELDS
	
	
	//METHODS
	
		//STANDARD MESSAGES // these are static methods for use inside and outside this class.
//		public static void saySorry() {
//			final String sorry = "Sorry, but that wasn't a valid input. Please choose again.";
//			System.out.println(sorry);
//		}
//
//		private static void askWhich() {
//			final String which = "You've got some options. Which do you select?";
//			System.out.println(which);
//		}
//		
//	
//		public static void askInput() {
//			final String input = "We need your input for this next part.";
//			System.out.println(input);
//		}
//		
//		public static void sayWelcome() {
//			final String welcome = "Welcome to Tyler's Banking Simulation!";
//			System.out.println(welcome);
//		}
//		
//		
		
		
		// INTERFACE METHODS // NEEDS OVERRIDE?
		public void displayStart() {
			System.out.println("(1) Login to my Customer Account.");
			System.out.println("(2) Setup my New Customer Account.");
			System.out.println("(3) Take me to the Employee Portal.");
		} 

		
		public void displayNewCust() {
			System.out.println("New Customer option 1");
			System.out.println("New Customer option 2");
		}
		
		
		public void displayCust() {
			System.out.println("Existing Customer option 1");
			System.out.println("Existing Customer option 2");
		}
		
		public void displayEmpPortal() {
			System.out.println("(1) Employee option");
			System.out.println("(2) other employee option");
		}
		
		
		public void displayEmpNew() {
			System.out.println("New employee message 1");
			System.out.println("New employee message 2");
		}
		
		
		public void displayEmpMain() {
			System.out.println("Employee portal option");
			System.out.println("Employee portal option 2");
		}


		
//		//CASE SWITCH for adding MENU TITLES to HEADER & FOOTER
//		public static String headOrFoot(String someMenuTitle) {
//					String msg = new String();
//					switch (someMenuTitle) {
//							case "start": msg = "start menu.";
//								break;
//							case "newCustomer": msg = "registration menu for new customers.";
//								break;
//							case "customer": msg = "account menu for existing customers.";
//								break;
//							case "allEmp": msg = "employee portal.";
//								break;
//							case "newEmp": msg = "new employee setup menu.";
//								break;
//							case "empMain": msg =  "employee main menu.";
//								break;
//						} return msg;
//				}
	

}
