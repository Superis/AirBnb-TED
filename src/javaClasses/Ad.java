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
	
	public void print(){
		System.out.println(id+" "+name+" "+desc+" "+city+" "+address+" "+country+" "+pic+" "+price+" "+ppr
				+" "+maxp+" "+beds+" "+wcs+" "+bedrooms+" "+living_rooms+" "+area);
	}
}
