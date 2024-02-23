package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import exceptions.InvalidUserException;

import pojo.User;
import dao.StoreInformation;


public class UserValidation {

	private Scanner sc;
	private Map<String, User> userMap;
	StoreInformation store;
	
	public UserValidation() {
		
		sc = new Scanner(System.in);
		userMap = new HashMap<>();
		store = new StoreInformation();
		
		/*
		 * Sample users are added to the userMap, where the username is the 
		 * key and the corresponding User object is the value.
		 */
		
		userMap.put("admin1", new User("admin1","password1","admin1@gmail.com"));
		userMap.put("user1", new User("user1","password2","user1@gmail.com"));
		userMap.put("user2", new User("user2","password2","user2@gmail.com"));

		
	}
	
	public void checkUser(String uname, String pwd) throws InvalidUserException {
        User user = userMap.get(uname);
        if (user != null && user.getPassword().equals(pwd)) {
            userMenu(); // User is authenticated, redirect to user menu
        } else {
            throw new InvalidUserException();
        }
    }

    public void checkAdmin(String uname, String pwd) throws InvalidUserException {
        if ("admin1".equals(uname) && "password1".equals(pwd)) {
            adminMenu(); // Admin is authenticated, redirect to admin menu
        } else {
            throw new InvalidUserException();
        }
    }
	
	 public void adminMenu() {
	        int option;
	        do {
	            displayMenu();
	            System.out.println("Enter your choice (or enter 0 to exit): ");
	            option = new Scanner(System.in).nextInt();
	            
	            if (option != 0) {
	                switchOption(option);
	            }
	        } while (option != 0);
	        
	        System.out.println("Exiting the application.");
	    }
	    
	    public void displayMenu() {
	    	System.out.println("Please select one of the following options: ");
	        System.out.println("1.	List the products in the store (productid, product Name, category, Quantity, price ) ");
	        System.out.println("2.	Search the product by using productid ");
	        System.out.println("3.	List the products by category (Grocery, Stationary, Toiletry, Vegetables) ");
	        System.out.println("4.	Search the product by using the name and view the details of the product. ");
	        System.out.println("5.	To check the total amount, spend on her products. ");
	        System.out.println("6.	Display the Profit amount that she gets on category wise.  ");
	        
	    	
	    }
	    
	    public void switchOption(int option) {
	        switch (option) {
	            case 1:
	                store.displayAllProducts();
	                
	                break;
	            case 2:
	                System.out.println("Enter product ID to search: ");
	                int productIdToSearch = new Scanner(System.in).nextInt();
	                store.searchProductById(productIdToSearch);
	                break;
	            case 3:
	                System.out.println("Enter category to list products: ");
	                String categoryToSearch = new Scanner(System.in).next();
	                store.searchProductByCategory(categoryToSearch);
	                break;
	            case 4:
	                System.out.println("Enter product name to search: ");
	                String productNameToSearch = new Scanner(System.in).next();
	                store.searchProductByName(productNameToSearch);
	                break;
	            case 5:
	            	store.totalAmountOnProduct();
	                break;
	            case 6:
	            	System.out.println("Enter category");
	            	String categoryprofit = new Scanner(System.in).next();
	            	store.calculateProfit(categoryprofit);
	                break;
	            default:
	                System.out.println("Invalid option. Please choose a valid option.");
	        }
	    }
	    
	    public void userMenu() {
	    	int option;
	    	
	    	 do {
		            displayMenuUser();
		            System.out.println("Enter your choice (or enter 0 to exit): ");
		            option = new Scanner(System.in).nextInt();
		            
		            if (option != 0) {
		                switchOptionUser(option);
		            }
		        } while (option != 0);
		        
		        System.out.println("Exiting the application.");
		    }
	    
	    public void displayMenuUser() {
	    	
	    	System.out.println("Please select one of the following options: ");
	        System.out.println("1.	View the products from the store. ");
	        System.out.println("2.	Search the product by using productid.  ");
	    	
	    }
	    
	   public void switchOptionUser(int option) {
	        switch (option) {
	            case 1:
	                store.displayAllProducts();
	                
	                break;
	                
	            case 2:
	                System.out.println("Enter product ID to search: ");
	                int productIdToSearch = new Scanner(System.in).nextInt();
	                store.searchProductById(productIdToSearch);
	                break;
	                
	            default:
	                System.out.println("Invalid option. Please choose a valid option.");
	        }
	    }
	    	
	    	
	    	
	    
	    public void register(){
	        User userd = new User();
	        
	        System.out.println("Enter user name ");
	        String username = sc.next();
	        System.out.println("Enter Password ");
	        String password = sc.next();
	        System.out.println("Enter Email ");
	        String email = sc.next();
	        
	        
	        
	        // Create a new User object with the entered information
	        User newUser = new User(username, password, email, 100);
	        userMap.put(username, newUser); // Add the registered user to the HashMap
	        System.out.println("New User Added Successfully");
	    }
	    
	
}
