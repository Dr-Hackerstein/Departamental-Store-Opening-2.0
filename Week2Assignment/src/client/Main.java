package client;

import  dao.StoreInformation;
import  dao.UserValidation;

import exceptions.InvalidUserException;

import java.util.*;

public class Main {
	
	private static Scanner sc;
	static UserValidation valid;
	
	
	
	public static void main(String[] args) {
		
		valid = new UserValidation();
		sc = new Scanner(System.in);
		
		System.out.println("Please select one of the following");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as User");
		System.out.println("3. Register");
		
		 int choice = sc.nextInt();
	     sc.nextLine(); // Consume newline character
		
		switch(choice) {
		
		case 1:
			System.out.println("Enter username:");
            String inputUsername = sc.nextLine();

            System.out.println("Enter password:");
            String inputPassword = sc.nextLine();
            
            try {
            	valid.checkAdmin(inputUsername, inputPassword);
            	
            }
			catch(InvalidUserException e) {
				System.out.println(e.getMessage());
			}
			break;
			
			
			
		case 2:
			
			System.out.println("Enter username:");
            String inputUsername1 = sc.nextLine();

            System.out.println("Enter password:");
            String inputPassword1 = sc.nextLine();
            
            try {
            	valid.checkUser(inputUsername1, inputPassword1);
            	
            }
			catch(InvalidUserException e) {
				System.out.println(e.getMessage());
			}
			break;
		
		
		case 3:	
			valid.register();
			
			

		}
		
	}

}
