package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pojo.Product;

public class StoreInformation {

    // The instance field of my class, a map of product ID to Product objects
    private Map<Integer, Product> products;

    /*
     * This constructor public StoreInformation() is a parameterless constructor for a class named StoreInformation.
     */
    public StoreInformation() {
        /*
         * Initializes a HashMap named products to store instances of the Product class.
         */
        this.products = new HashMap<>();

        /*
         * Creates three instances of the Product class (p1, p2, p3) and sets their properties
         * (such as product ID, name, available quantity, category, buying price, and item name).
         */
        Product p1 = new Product();
        p1.setProductid(1);
        p1.setProductname("Mouse");
        p1.setAvailableQuantity(2);
        p1.setCategory("Computer");
        p1.setBuyingPrice(40000.0);
        p1.setItemname("Mouse");

        Product p2 = new Product();
        p2.setProductid(2);
        p2.setProductname("Laptop");
        p2.setAvailableQuantity(2);
        p2.setCategory("Computer");
        p2.setBuyingPrice(50000.0);
        p2.setItemname("Laptop");

        Product p3 = new Product();
        p3.setProductid(3);
        p3.setProductname("Book");
        p3.setAvailableQuantity(3);
        p3.setCategory("Stationery");
        p3.setBuyingPrice(300.0);
        p3.setItemname("Book");

        /*
         * Adds the three Product instances (p1, p2, p3) to the products HashMap
         * using the product ID as the key.
         */

        this.products.put(p1.getProductid(), p1);
        this.products.put(p2.getProductid(), p2);
        this.products.put(p3.getProductid(), p3);

        /*
         * This constructor essentially initializes the products HashMap with three initial
         * Product objects containing predefined information. It's commonly used to set up initial
         * data or state when an object of the StoreInformation class is created without any parameters.
         */
    }

    
    public void startApplication() {
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
                displayAllProducts();
                
                break;
            case 2:
                System.out.println("Enter product ID to search: ");
                int productIdToSearch = new Scanner(System.in).nextInt();
                searchProductById(productIdToSearch);
                break;
            case 3:
                System.out.println("Enter category to list products: ");
                String categoryToSearch = new Scanner(System.in).next();
                searchProductByCategory(categoryToSearch);
                break;
            case 4:
                System.out.println("Enter product name to search: ");
                String productNameToSearch = new Scanner(System.in).next();
                searchProductByName(productNameToSearch);
                break;
            case 5:
            	totalAmountOnProduct();
                break;
            case 6:
            	System.out.println("Enter category");
            	String categoryprofit = new Scanner(System.in).next();
            	calculateProfit(categoryprofit);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
    
    public void displayAllProducts() {
        System.out.println("Displaying All Products ");
        for (Map.Entry<Integer, Product> entry : this.products.entrySet()) {
            Product product = entry.getValue();
            System.out.println("Product name is " + product.getProductname());
            System.out.println("Product Quantity is " + product.getAvailableQuantity());
            System.out.println("Buying price is " + product.getBuyingPrice());
        }
    }
    
    
    public void searchProductById(int prodid) {
    	
        Product product = products.get(prodid);
        if (product != null) {
            System.out.println("Product name by id " + product.getProductname());
            System.out.println("Product Category by id " + product.getCategory());
        } 
        else{
            System.out.println("Product not found with id: " + prodid);
        }
    }
    
    public int searchProductByCategory(String category) {
        int searchLength = 0;

        for (Product product : products.values()) {
            if (product.getCategory().equals(category)) {
                System.out.println("Product name by category: " + product.getProductname());
                System.out.println("Product Category: " + product.getCategory());
                System.out.println("Buying Price: " + product.getBuyingPrice());
                ++searchLength;
            }
        }

        return searchLength;
    }
    
    
 // Method to search for a product by name
    public void searchProductByName(String name) {
        for (Product product : products.values()) {
            if (product.getProductname().equals(name)) {
                System.out.println("Product name: " + product.getProductname());
                System.out.println("Product Category: " + product.getCategory());
                System.out.println("Buying Price: " + product.getBuyingPrice());
                return;
            }
        }
        System.out.println("Product not found with name: " + name);
    }
    
    public void totalAmountOnProduct() {
        double totalAmount = 0.0;

        for (Product product : products.values()) {
            if (product.getBuyingPrice() != 0.0) {
                totalAmount += product.getBuyingPrice();
            }
        }

        System.out.println("Total Amount Spent On Products: " + totalAmount);
    }
    
 // Method to calculate profit for products in a specific category
    public void calculateProfit(String category) {
        double totalProfit = 0.0;

        for (Product product : products.values()) {
            if (product.getCategory().equals(category)) {
                double profit = product.getSellingPrice() - product.getBuyingPrice();
                totalProfit += profit;
            }
        }

        System.out.println("Total Profit for Category " + category + ": " + totalProfit);
    }
    
    
    public Map<Integer, Product> storeData() {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Product> prdMap = new HashMap<>();

        System.out.println("Enter number of products you want to store:");
        int noofproduct = sc.nextInt();

        for (int x = 0; x < noofproduct; x++) {
            Product p1 = new Product();

            System.out.println("Enter product id:");
            int productid = sc.nextInt();
            p1.setProductid(productid);

            System.out.println("Enter Product name:");
            p1.setProductname(sc.next());

            System.out.println("Enter Available Quantity:");
            p1.setAvailableQuantity(sc.nextInt());

            System.out.println("Enter Category:");
            p1.setCategory(sc.next());

            System.out.println("Enter Buying price:");
            p1.setBuyingPrice(sc.nextDouble());

            prdMap.put(productid, p1);
        }
        
        sc.close(); // Close the scanner to release resources
        
        return prdMap;
    }

}

