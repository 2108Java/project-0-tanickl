package com.revature.tan.presentation;

import com.revature.tan.presentation.ConsoleSession;



public abstract class AbstractDisplays {
		
	//NO FIELDS
		
		// METHODS FOR EXTENSION IN CHILD OVERRIDES OF INT METHODS
		public void displayStart() {
			System.out.println("(1) Login to my Customer Account.");
			System.out.println("(2) Setup my New Customer Account.");
			System.out.println("(3) Login to Employee Menu.");
			System.out.println("(4) Setup my New Employee Account.");
		} 

		
		
		public void menuEmp() {
			System.out.println("(1) View all accounts.");
			System.out.println("(2) Search accounts by customer name.");
			System.out.println("(3) Approve pending accounts.");
			System.out.println("(4) View the transaction log.");
		}
		



		public void menuCust() {
			System.out.println("(1) Register for an additional account.");
			System.out.println("(2) View my account balances.");
			System.out.println("(3) View my transactions.");
			System.out.println("(4) Make a deposit.");
			System.out.println("(5) Make a withdrawal.");
			System.out.println("(6) Transfer funds between my accounts.");
			System.out.println("(7) Transfer funds to another user.");
			System.out.println("(8) Authorize a joint user.");
			System.out.println("(0) Exit session and start over.");
		}

}
