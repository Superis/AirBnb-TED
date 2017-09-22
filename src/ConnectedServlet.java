

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javaClasses.Ad;
import javaClasses.DateUtil;
import javaClasses.User;
import javaClasses.mysqlConnector;

/**
 * Servlet implementation class ConnectedServlet
 */
@WebServlet("/ConnectedServlet")
@MultipartConfig
public class ConnectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   
		if(request.getParameter("admin") != null){
			mysqlConnector Connector = new mysqlConnector();
			Connector.establishConnection();
			List<User> usrList = null;
			try {
				usrList = Connector.allUsers();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Connector.destroyConnection();
			}
			request.setAttribute("users",usrList);
			request.getRequestDispatcher("/res/jsp/admin_page.jsp").forward(request, response);
		}
		else if(request.getParameter("saveChanges") != null){
			System.out.println("Changes have been saved!");
			String fileName;
			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		    //if (filePart==null)
		    	//fileName="";
		    //else{
			fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    InputStream fileContent = filePart.getInputStream();
		    //String loc=.getServletContext().getRealPath("/WebContent/res/img");
		    File folder=new File("/home/paris/Pictures/TEDImages");
		    File file=new File(folder,fileName);
		    file.setReadable(true, false);
		    file.setExecutable(true, false);
		    file.setWritable(true, false);
		    System.out.println(file.toPath());
		    Files.copy(fileContent, file.toPath());
		    //}
			mysqlConnector connector = new mysqlConnector();
			connector.establishConnection();
			try {
				connector.updateUserInfo((String)request.getSession(false).getAttribute("user"),request.getParameter("password")
						,request.getParameter("phone"),request.getParameter("email"),fileName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
			connector.destroyConnection();
			}
			
			//request.getRequestDispatcher("/res/jsp/login_success.jsp").forward(request, response);
			request.getRequestDispatcher("/res/jsp/login_success.jsp").forward(request, response);
		}
		else if(request.getParameter("submitAd") != null){
			
			 String fileName ="none";
			 Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			  if (filePart != null){
			  	//fileName="";
			  //else{
			 fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			 InputStream fileContent = filePart.getInputStream();
			 //String loc=.getServletContext().getRealPath("/WebContent/res/img");
			 File folder=new File("/home/paris/Pictures/TEDImages");
			 File file=new File(folder,fileName);
			 file.setReadable(true, false);
			 file.setExecutable(true, false);
			 file.setWritable(true, false);
			 System.out.println(file.toPath());
			 Files.copy(fileContent, file.toPath());
			  }
			 String[] tokkens = request.getParameter("position").split(", ");//0 address, 1 city + postal code, 2 country
			 String address = tokkens[0];
			 String city_postal = tokkens[1];
			 String country = tokkens[2];
			 tokkens =  city_postal.split(" ");//0 city 1+2 postal code
			 String city = tokkens[0];
			 
			 //System.out.println(request.getParameter("from")+request.getParameter("to"));
			 //room.print();
			 List<String> dates = new DateUtil().getDatesBetweenDates(request.getParameter("from"), request.getParameter("to"));
			 
			 if(request.getParameter("func").equals("insert")){
				 
				 Random rnd = new Random();
				 int n = 100000 + rnd.nextInt(900000);
				 String id = Integer.toString(n); 
				 Ad room = new Ad(id,request.getParameter("access"),request.getParameter("description"),city,address,country,"/files/"+fileName,request.getParameter("minprice"),request.getParameter("adcost"),request.getParameter("maxpeople")
						 ,request.getParameter("type"),request.getParameter("beds"),request.getParameter("wcs"),request.getParameter("bedrooms"),request.getParameter("living_rooms"),request.getParameter("area"));
				 
				 try {
					 mysqlConnector Connector = new mysqlConnector();
					 Connector.establishConnection();
					 Connector.addAd(room, request.getSession(false).getAttribute("user").toString(),dates);
					 Connector.destroyConnection();
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			 }
			 else if(request.getParameter("func").equals("update")){
				 
				 String id = request.getParameter("id");
				 Ad room = new Ad(id,request.getParameter("access"),request.getParameter("description"),city,address,country,"/files/"+fileName,request.getParameter("minprice"),request.getParameter("adcost"),request.getParameter("maxpeople")
						 ,request.getParameter("type"),request.getParameter("beds"),request.getParameter("wcs"),request.getParameter("bedrooms"),request.getParameter("living_rooms"),request.getParameter("area"));

				 try {
					 mysqlConnector Connector = new mysqlConnector();
					 Connector.establishConnection();
					 Connector.updateAd(room);
					 Connector.destroyConnection();
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 response.sendRedirect("/TED/ConnectedServlet");
		}
		else request.getRequestDispatcher("/res/jsp/login_success.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
