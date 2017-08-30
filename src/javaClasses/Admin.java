package javaClasses;

public class Admin {

	private static String name = "admin";
	private static String password = "admin";
	private static boolean loggedIn = false;
	
	public static synchronized String getName(){
		return name;
	}
	
	public static synchronized String getPassword(){
		return name;
	}
	
	public static synchronized boolean checkIfAdmin(String gname, String gpassword){
		if(name.equals(gname) && password.equals(gpassword) && !loggedIn){
			loggedIn = true;
			return true;
		}
		else return false;
	}
	
	public static synchronized void logout(){
		loggedIn = false;
	}
	
	public static synchronized boolean check(String gname){
		if(name.equals(gname)) return true;
		else return false;
	}
}
