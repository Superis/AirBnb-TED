package javaClasses;
import javaClasses.User;
import javaClasses.Auser;
import javaClasses.Ad;
import java.util.ArrayList;
import java.util.List;

public class Ausers {
	public List<Auser> userlist;
	public Ausers() {
		this.userlist=new ArrayList<Auser>();
	}
	public void addAuser(Auser newAuser) {
		userlist.add(newAuser);
	}
}
