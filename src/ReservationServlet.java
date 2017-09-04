

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import javaClasses.*;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mysqlConnector mysql = new mysqlConnector();
		mysql.establishConnection();
		try {
			mysql.makeReservation(request.getParameter("user"),request.getParameter("id"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		try {
			mysql.holdRoom(request.getParameter("id"),(String)session.getAttribute("from"),(String)session.getAttribute("to"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		mysql.destroyConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
