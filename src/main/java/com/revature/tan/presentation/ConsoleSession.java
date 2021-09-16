package com.revature.tan.presentation;
import java.util.Scanner;
import com.revature.tan.presentation.Menus;

public class ConsoleSession extends Displays {

	//FIELDS
	public Menus lastMenu;
	public Menus currentMenu;
	public Menus nextMenu;
	
	
	
	//CONSTRUCTOR
	public ConsoleSession() {
		Menus lastMenu = null;
		Menus nextMenu = null;
		Menus currentMenu = new Start s; //need to add pojo class for Start
	}
	
	
	
	//will get inputs and launch menus, and those menus will return ConsoleSession objs,
	//so I can keep tracking the user over the whole session.
	public void launchMenus() {
		//new scanner
		//maybe a switch block
		
	}
	
	
	

}
