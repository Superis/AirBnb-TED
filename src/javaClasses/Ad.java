package javaClasses;

public class Ad {

	public String id;
	public String name;
	public String desc;
	public String city;
	public String state;
	public String country;
	public String pic;
	public String price;
	
	public Ad(String id, String name, String desc, String city, 
			String state, String country, String pic, String price){
		
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pic = pic;
		this.price = price;
	}
	
	public void print(){
		System.out.println(id);
	}
}
