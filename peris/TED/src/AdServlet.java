

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import javaClasses.Ad;
import javaClasses.mysqlConnector;

/**
 * Servlet implementation class ADd
 */
@WebServlet("/AdServlet")
public class AdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 mysqlConnector Connector = new mysqlConnector();
		 Connector.establishConnection();
		 String userid = request.getParameter("id");
		 List<Ad> rs = null;
		 try{
			 if(userid!=null)
				 rs = Connector.searchForAds("ID",userid);
		 }catch(SQLException e){
			 e.printStackTrace();
		 }	
		 request.setAttribute("results",rs);
		 request.getRequestDispatcher("/res/jsp/ad.jsp").forward(request, response);
		 
		 
	}	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
