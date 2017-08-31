package datapackage;

public class Listing {
	  public static final String GENDER_MALE ="M";
	   public static final String GENDER_FEMALE = "F";
	    
	   private String name;
	   private int id;
	   private String description;
	   private String city;
	   private String state;
	   private String country;
	    
	 
	   public Listing() {
	        
	   }
	    
	   public String getName() {
	       return name;
	   }
	   public void setName(String name) {
	       this.name = name;
	   }
	 
	   public int getId() {
	       return id;
	   }
	 
	   public void setGender(int id) {
	       this.id = id;
	   }
	 
	   public String getDescription() {
	       return description;
	   }
	 
	   public void setDescription(String description) {
	       this.description = description;
	   }
	
	
}
