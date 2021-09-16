package com.revature.tan.presentation;
import java.util.Scanner;
import com.revature.tan.presentation.ConsoleSession;

//This abstract class handles my app's communication to the user by printing messages to the console.
//Because the menus and messages displayed in this app are very routine, the partial abstraction
//an abstract class provides allows me to store a lot of repetitive println statements here
//so that the bodies of extending subclasses are not cluttered with unnecessary overrides.



public abstract class Displays {
		
	//FIELDS

	
	
	//METHODS
	
		//STANDARD MESSAGES // these are static methods for use WITHIN other methods of this class
		private static void saySorry() {
			String sorry = "Sorry, but that wasn't a valid input. Please choose again.";
			System.out.println(sorry);
		}

		private static void askWhich() {
			String which = "You've got some options. Which do you select?";
			System.out.println(which);
		}
		
	
		private static void askInput() {
			String input = "We need your input for this next part.";
			System.out.println(input);
		}
		
		
		
		
		
		
		// REPEATED DISPLAYS
		public void displayStart() {
			System.out.println("Welcome to Tyler's Banking Simulation!");
			Displays.headOrFoot(go.getCurrentMenu().menuTitle());
			Displays.askWhich();
			System.out.println("(1) Login to my Customer Account.");
			System.out.println("(2) Setup my New Customer Account.");
			System.out.println("(3) Take me to the Employee Portal.");
		} 

		
		public void displayNewCust() {
			Displays.headOrFoot(go.getCurrentMenu().menuTitle());
			Displays.askWhich();
			System.out.println("New Customer option 1");
			System.out.println("New Customer option 2");
			Displays.headOrFoot(go.getLastMenu().menuTitle());
		}
		
		
		public void displayCust() {
			Displays.headOrFoot(go.getCurrentMenu().menuTitle());
			Displays.askWhich();System.out.println("Existing Customer option 1");
			System.out.println("Existing Customer option 2");
			Displays.headOrFoot(go.getLastMenu().menuTitle());
		}
		
		public void displayEmpPortal() {
			Displays.headOrFoot(go.getCurrentMenu().menuTitle());
			Displays.askWhich();
			System.out.println("(1) Employee option");
			System.out.println("(2) other employee option");
			Displays.headOrFoot(go.getLastMenu().menuTitle());
		}
		
		
		public void displayEmpNew() {
			Displays.headOrFoot(go.getCurrentMenu().menuTitle());
			Displays.askWhich();
			System.out.println("New employee message 1");
			System.out.println("New employee message 2");
			Displays.headOrFoot(go.getLastMenu().menuTitle());		
		}
		
		
		public void displayEmpMain() {
			Displays.headOrFoot(go.getCurrentMenu().menuTitle());
			Displays.askWhich();
			System.out.println("Employee portal option");
			System.out.println("Employee portal option 2");
			Displays.headOrFoot(go.getLastMenu().menuTitle());
		}

		
	
		private static String headOrFoot(String someMenuTitle) {
				String  msg = new String();
					switch (someMenuTitle) {
						case "start": msg = "start menu.";
							break;
						case "newCustomer": msg = "registration menu for new customers.";
							break;
						case "customer": msg = "account menu for existing customers.";
							break;
						case "allEmp": msg = "employee portal.";
							break;
						case "newEmp": msg = "new employee setup menu.";
							break;
						case "empMain": msg =  "employee main menu.";
							break;
					} if ( someMenuTitle = go.getCurrentMenu().menuTitle()) {
							System.out.println("You are now viewing the " + msg);
						} if ( someMenuTitle = go.getLastMenu().menuTitle()) {
							System.out.println("Enter '0' to go BACK to the " + msg);
						}
		}
		

}
