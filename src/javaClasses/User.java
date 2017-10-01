package javaClasses;

public class User {
	String username;
	String password;
	String email;
	String phone;
	String role;
	String image;
	
	public User(String username, String password
			,String email, String phone, String role, String image){
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.image = image;
	}
	
	public User(User newuser) {
		this.username = newuser.username;
		this.password = newuser.password;
		this.email = newuser.email;
		this.phone = newuser.phone;
		this.role = newuser.role;
		this.image = newuser.image;
	}


	public String getUsername(){
		return username;
	}
	
	public void getAll(String[] strs){
		strs[0] = username;
		strs[1] = password;
		strs[2] = email;
		strs[3] = phone;
		strs[4] = role;
		strs[5] = image;
	}
}
