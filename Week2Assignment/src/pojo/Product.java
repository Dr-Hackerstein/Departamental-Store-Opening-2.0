package pojo;

public class Product extends Item {
	

   private int productid;
   private double sellingPrice;
   private String productname;
   private int availableQuantity;
   
   public Product(int productid, String productname, int availableQuantity) {
	      this.productid = productid;
	      this.productname = productname;
	      this.availableQuantity = availableQuantity;
	   }
   
   public Product() {
	   
   }

   public int getProductid() {
      return this.productid;
   }

   public void setProductid(int productid) {
      this.productid = productid;
   }

   public String getProductname() {
      return this.productname;
   }

   public void setProductname(String productname) {
      this.productname = productname;
   }

   public int getAvailableQuantity() {
      return this.availableQuantity;
   }

   public void setAvailableQuantity(int availableQuantity) {
      this.availableQuantity = availableQuantity;
   }
   
   
   // The selling price is automatically set with the next formula
   public double getSellingPrice() {
      this.sellingPrice = this.getBuyingPrice() * 0.05 + this.getBuyingPrice();
      return this.sellingPrice;
   }

   public void setSellingPrice(double sellingPrice) {
   }


  
}