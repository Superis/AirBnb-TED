

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javaClasses.Ad;
import javaClasses.User;
import javaClasses.Listing;
import javaClasses.mysqlConnector;
import javaClasses.Auser;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javaClasses.Ausers;
import java.io.FileOutputStream;
/*
 * Servlet implementation class XMLServlet
 */
@WebServlet("/XMLServlet")
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XMLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 mysqlConnector Connector = new mysqlConnector();
		 Connector.establishConnection();
		 String file_path="/home/paris/xml/myxml";
		 String ad_file_path="/home/paris/xml/adxml";
		 String list_file_path="/home/paris/xml/listxml";
		 FileOutputStream fos = null;
		 FileOutputStream adfos=null;
		 FileOutputStream listfos=null;
		 XStream xstream = new XStream();
		 xstream.alias("user", User.class);
		 xstream.useAttributeFor(User.class, "username");
		 xstream.alias("Ad",Ad.class);
		 xstream.alias("AdminXML", Ausers.class);
		 xstream.useAttributeFor(Ad.class,"id");
		 xstream.alias("Listings", Listing.class);
		 xstream.useAttributeFor(Listing.class, "name");
		// xstream.aliasField("name", Student.class, "studentName");
		 xstream.alias("User-Ads",Auser.class );
		Ausers auserads=new Ausers();
		 
		  fos = new FileOutputStream(file_path	 + ".xml");
		   fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
		  adfos = new FileOutputStream(ad_file_path	 + ".xml");
		  adfos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
		  listfos = new FileOutputStream(list_file_path	 + ".xml");
		  listfos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
			List<User> myusers=null;
			List<Ad> myads=new ArrayList<Ad>();
			List<Ad> tempads=new ArrayList<Ad>();
			List<Ad> listings=null;
			try {
				myusers = Connector.allUsers();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				listings= Connector.allRooms();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		
		// TODO Auto-generated catch block
			
		String[] strs = new String[6]; //user details
		 
		 if(myusers != null){
		  for(User temp: myusers){
		 	  temp.getAll(strs);
		 	  try {
				myads.addAll(Connector.searchForAds(temp.getUsername()));
				tempads.addAll(Connector.searchForAds(temp.getUsername()));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 	  Auser auser=new Auser(temp,myads);
				auserads.addAuser(auser);
				  myads.clear();
				 
		  }
		  try{            
			  String xml = xstream.toXML(auserads);
		      byte[] bytes = xml.getBytes("UTF-8");
		      fos.write('\n');
		      fos.write(bytes);
		     fos.write('\n');
		     //System.out.println(auserads.ausers.size());
		  }catch (Exception e){
		      System.err.println("Error in XML Write: " + e.getMessage());
		  }
		  if(myads!=null) {
			  for(Ad tempad:tempads) {
				  try{            
					  String adxml = xstream.toXML(tempad);
				      byte[] bytes = adxml.getBytes("UTF-8");
				      adfos.write('\n');
				      adfos.write(bytes);
				    adfos.write('\n');
				  }catch (Exception e){
				      System.err.println("Error in XML Write: " + e.getMessage());
				  }
				  
		  }
			 
		  }
		  
		
		  }
		 if(listings!=null) {
			 for (Ad ltemp:listings) {
				 try{            
					  String listingxml = xstream.toXML(ltemp);
				      byte[] bytes = listingxml.getBytes("UTF-8");
				      listfos.write('\n');
				      listfos.write(bytes);
				    listfos.write('\n');
				  }catch (Exception e){
				      System.err.println("Error in XML Write: " + e.getMessage());
				  }
			 }
		 }
	
		  
		 fos.close();
		 adfos.close();
		 listfos.close();
		 response.sendRedirect("/TED/Servlet");
		 return;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
		  
		  
