package com.revature.tan.models;

public class Account {

	//FIELDS
	private int owner;
	private int number;
	private boolean isApproved;
	private double balance;
	
	
	//CONSTRUCTORS
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(int owner, int number, boolean isApproved, double balance) {
		super();
		this.owner = owner;
		this.number = number;
		this.isApproved = isApproved;
		this.balance = balance;
	}


	//GETTERS & SETTERS
	public int getOwner() {
		return owner;
	}


	public void setOwner(int owner) {
		this.owner = owner;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	

}

