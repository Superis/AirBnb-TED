package javaClasses;

public class Listing {
	  public static final String GENDER_MALE ="M";
	   public static final String GENDER_FEMALE = "F";
	    
	   private String name;
	   private String id;
	   private String description;
	   private String city;
	   private String state;
	   private String country;
	   private String pic;
	   private String price;
	   
	   public Listing(String name,String id,String desc,String city,String state,String country,String pic,String price) {
		this.name=name;
		this.id=id;
		this.description=desc;
		this.city=city;
		this.state=state;
		this.country=country;
		this.pic=pic;
		this.price=price;

	}
	   
	   public String getName() {
		   return name;
	   }
	   public void setName(String name) {
		   this.name=name;
	   }
	   public String getCity() {
	       return city;
	   }
	   public void setCity(String city) {
	       this.city = city;
	   }
	 
	   public String getId() {
	       return id;
	   }
	 
	   public void setId(String id) {
	       this.id = id;
	   }
	 
	   public String getDescription() {
	       return description;
	   }
	 
	   public void setDescription(String description) {
	       this.description = description;
	   }
	   public String getCountry() {
	       return country;
	   }
	 
	   public void setCountry(String country) {
	       this.country = country;
	   }
	 
	   public String getState() {
	       return state;
	   }
	 
	   public void setState(String state) {
	       this.state = state;
	   }
	   public String getPic() {
		   return pic;
	   }
	   public void setPic(String pic) {
		   this.pic=pic;
	   }
	   public String getPrice() {
	       return price;
	   }
	   public void setPrice(String price) {
	       this.price = price;
	   }
	
}
