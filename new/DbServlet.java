

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.Ad;
import javaClasses.mysqlConnector;

/**
 * Servlet implementation class DbServlet
 */
@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbServlet() {
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
		 
		 if(request.getParameter("settings") != null && request.getParameter("settings").equals("show")){
			 
			 ResultSet rs = null;
			 
			 try {
				rs = Connector.userInfo((String) request.getSession(false).getAttribute("user"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally{
				// Connector.destroyConnection();
			 }
			request.setAttribute("results", rs);
			request.getRequestDispatcher("/res/jsp/settings.jsp").forward(request, response);
			return;
		 }
		 else if(request.getParameter("submitAd") != null){
			 String access = request.getParameter("access");
			 String desc = request.getParameter("description");
			 String rules = request.getParameter("rules");
			 String from = request.getParameter("from");
			 String to = request.getParameter("to");
			 String maxpeople = request.getParameter("maxpeople");
			 String minprice = request.getParameter("minprice");
			 String adcost = request.getParameter("adcost");
			 String type = request.getParameter("type");
			 String beds = request.getParameter("beds");
			 String wcs = request.getParameter("wcs");
			 String bedrooms = request.getParameter("bedrooms");
			 String living_rooms = request.getParameter("living_rooms");
			 String area = request.getParameter("area");
		System.out.println("YOYOYO");
		response.sendRedirect("/TED/res/jsp/login_success.jsp");
		return;
		 }
		 else if(request.getParameter("send_message") != null){
			 
			 try {
				Connector.sendMessageToHost(request.getParameter("from"), request.getParameter("id"), request.getParameter("content"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				Connector.destroyConnection();
			}
		 }
		 else if(request.getParameter("show_messages") != null){
			 try {
				List<String> messages = Connector.showMessages(request.getParameter("user"));
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("/res/jsp/show_messages.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally{
				 Connector.destroyConnection();
			 }
		 }
		 else {
			 String myinfo = request.getParameter("count");
			 String cityname=request.getParameter("str");
			 System.out.println(cityname);
			 List<Ad> rs = null;
			 try {
				 rs = Connector.searchForAds("CITY",cityname);
			 } catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
			 finally{
				 Connector.destroyConnection();
			 }
			 request.setAttribute("results", rs);
			 request.getRequestDispatcher("/res/jsp/results.jsp?str="+cityname+"&count="+myinfo).forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(request.getParameter("str"));
		//response.sendRedirect("./res/jsp/results.jsp?str="+request.getParameter("str"));
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
