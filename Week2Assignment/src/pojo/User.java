package pojo;

public class User {
	
	// What does a User have?
	// We declare these private to access them with getters and setters
	private String username; //private means that it isn't accessible put this class
	private String emailId;
	private String password;
	private int superCoins;
	
	
	// I create a constructor for my class 
	
	public User() {
		
	}
	
	public User(String username, String emailId, String password) {
        this.username = username;
        this.emailId = emailId;
        this.password = password;
	   }

	public User(String username, String emailId, String password, int superCoins) {
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.superCoins = superCoins;
	   }

	
	public String getUsername() {
		return username;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getSuperCoins() {
		return superCoins;
	}
	
	public void setSuperCoins(int superCoins) {
		this.superCoins = superCoins;
	}
	
	

}
