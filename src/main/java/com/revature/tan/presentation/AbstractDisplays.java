package com.revature.tan.presentation;

import com.revature.tan.presentation.ConsoleSession;



public abstract class AbstractDisplays {
		
	//NO FIELDS
		
		// METHODS FOR EXTENSION IN CHILD OVERRIDES OF INT METHODS
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


}
