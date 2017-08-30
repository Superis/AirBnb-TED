

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 String myinfo = request.getParameter("count");
		 String cityname=request.getParameter("str");
		 System.out.println(cityname);
		 ResultSet rs = null;
		 try {
			rs = Connector.searchForAds("CITY",cityname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("results", rs);
		request.getRequestDispatcher("/res/jsp/results.jsp?str="+cityname+"&count="+myinfo).forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(request.getParameter("str"));
		//response.sendRedirect("./res/jsp/results.jsp?str="+request.getParameter("str"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
