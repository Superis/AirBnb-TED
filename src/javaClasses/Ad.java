package javaClasses;

public class Ad {
	
		public String id;
		public String name;
		public String desc;
		public String city;
		public String address;
		public String country;
		public String pic;
		public String price;
		public float ppr;
		public int maxp;
		public String type;
		public int beds;
		public int wcs;
		public int bedrooms;
		public int living_rooms;
		public float area;
		public int reviewnum;
		public int totalrev;
		
		public Ad(String id, String name, String desc, String city, String address, String country, String pic,
				String price,String ppr,String maxp,String type,String beds,String wcs,String brooms,String lrooms,String area,String rev,String total){
			
			this.id = id;
			this.name = name;
			this.desc = desc;
			this.city = city;
			this.address = address;
			this.country = country;
			if(pic.equals("")) this.pic = null;
			else this.pic = pic;
			this.price = price;
			if(ppr != null && !ppr.equals("")) this.ppr = Float.parseFloat(ppr);
			if(maxp != null && !maxp.equals("")) this.maxp = Integer.parseInt(maxp);
			this.type = type;
			if(beds != null && !beds.equals("")) this.beds = Integer.parseInt(beds);
			if(wcs != null && !wcs.equals("")) this.wcs = Integer.parseInt(wcs);
			if(brooms != null && !brooms.equals(""))
			this.bedrooms = Integer.parseInt(brooms);
			if(lrooms != null && !lrooms.equals("")) this.living_rooms = Integer.parseInt(lrooms);
			if(area != null && !area.equals("")) this.area = Float.parseFloat(area);
			if(rev != null && !rev.equals("")) this.reviewnum = Integer.parseInt(rev);
			if(total != null && !total.equals("")) this.totalrev = Integer.parseInt(total);
			
			//print();
			
		}
		
		public Ad(String id, String name, String desc, String city, String address, String country, String pic,
				String price,String ppr,String maxp,String type,String beds,String wcs,String brooms,String lrooms,String area){
			
			this.id = id;
			this.name = name;
			this.desc = desc;
			this.city = city;
			this.address = address;
			this.country = country;
			this.pic = pic;
			this.price = price;
			if(ppr != null && !ppr.equals("")) this.ppr = Float.parseFloat(ppr);
			if(maxp != null && !maxp.equals("")) this.maxp = Integer.parseInt(maxp);
			this.type = type;
			if(beds != null && !beds.equals("")) this.beds = Integer.parseInt(beds);
			if(wcs != null && !wcs.equals("")) this.wcs = Integer.parseInt(wcs);
			if(brooms != null && !brooms.equals(""))
			this.bedrooms = Integer.parseInt(brooms);
			if(lrooms != null && !lrooms.equals("")) this.living_rooms = Integer.parseInt(lrooms);
			if(area != null && !area.equals("")) this.area = Float.parseFloat(area);
			
			
		}
		
		public Ad(String id, String name, String desc, String city, 
				String state, String country, String pic, String price){
			
			this.id = id;
			this.name = name;
			this.desc = desc;
			this.city = city;
			this.address=address;
			this.country = country;
			this.pic = pic;
			this.price = price;
		}
		
		public void print(){
			System.out.println(id+" "+name+" "+desc+" "+city+" "+address+" "+country+" "+pic+" "+price+" "+ppr
					+" "+maxp+" "+beds+" "+wcs+" "+bedrooms+" "+living_rooms+" "+area+" "+reviewnum+" "+totalrev);
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
	       return desc;
	   }
	 
	   public void setDescription(String description) {
	       this.desc = description;
	   }
	   public String getCountry() {
	       return country;
	   }
	 
	   public void setCountry(String country) {
	       this.country = country;
	   }
	 
	   /*public String getState() {
	       return state;
	   }
	 
	   public void setState(String state) {
	       this.state = state;
	   }*/
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
