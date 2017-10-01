package javaClasses;


import java.util.ArrayList;
import java.util.List;
public class Auser{
		User aduser;
		List<Ad> userads;
		public Auser(User newuser,List<Ad> otherlist) {
			this.aduser=new User(newuser);
			if(otherlist!=null)
			this.userads= new ArrayList<Ad>(otherlist);
		}
	}

