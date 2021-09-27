package com.revature.tan.presentation;

import com.revature.tan.presentation.ConsoleSession;



public abstract class AbstractDisplays {
		
	//NO FIELDS
		
		// METHODS FOR EXTENSION IN CHILD OVERRIDES OF INT METHODS
		public void displaySpace() {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
		}
	
	
		public void displayStart() {
			System.out.println("(1) Login existing Customer or Employee.");
			System.out.println("(2) Setup a New Customer or Employee User.");
		} 

		
		
		public void menuEmp() {
			System.out.println("(1) View all accounts.");
			System.out.println("(2) Search accounts by customer name.");
			System.out.println("(3) Approve a pending account.");
			System.out.println("(4) Reject a pending account.");
			System.out.println("(5) View the transaction log.");
			System.out.println("(0) Exit session and start over.");
		}
		



		public void menuCust() {
			System.out.println("(1) Register for an additional account.");
			System.out.println("(2) View my account balances.");
			System.out.println("(3) View my transactions.");
			System.out.println("(4) Make a deposit.");
			System.out.println("(5) Make a withdrawal.");
			System.out.println("(6) Transfer funds between my accounts.");
			System.out.println("(7) Transfer funds to another user.");
			System.out.println("(0) Exit session and start over.");
		}

}
