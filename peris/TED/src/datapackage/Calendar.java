package datapackage;

import java.util.Date;

public class Calendar {
	
	   private int listing_id;
	   private java.sql.Date date;
	   private String available;
	   private float price;
	 
	   public Calendar() {
	 
	   }
	 
	   public Calendar(int id,java.sql.Date date, String available, float price) {
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
	 
	   public java.sql.Date getDate(){
		   return date;
	   }
	   
	   public void setDate(java.sql.Date date) {
	       this.date = date;
	   }
	   
	   public float getPrice() {
	       return price;
	   }
	 
	   public void setPrice(float price) {
	       this.price = price;
	   }
	 

}
