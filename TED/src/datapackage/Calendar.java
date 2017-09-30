package datapackage;

import java.util.Date;

public class Calendar {
	
	   private int listing_id;
	   private String date;
	   private String available;
	   private String price;
	 
	   public Calendar() {
	 
	   }
	 
	   public Calendar(int id,String date, String available, String price) {
	       this.listing_id = id;
	       this.date=date;
	       this.available = available;
	       this.price = price;
	   }
	 
	   public String getAvailable() {
	       return available;
	   }
	 
	   public void setAvailable(String available) {
	       this.available = available;
	   }
	 
	   public int getID() {
	       return listing_id;
	   }
	 
	   public void setID(int id) {
	       this.listing_id = id;
	   }
	 
	   public String getDate(){
		   return date;
	   }
	   
	   public void setDate(String date) {
	       this.date = date;
	   }
	   
	   public String getPrice() {
	       return price;
	   }
	 
	   public void setPrice(String price) {
	       this.price = price;
	   }
	 

}
