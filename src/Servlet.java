

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaClasses.Admin;
import javaClasses.mysqlConnector;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("register") != null)
		{


			if(request.getParameter("ruser").equals("") || request.getParameter("rpassword").equals("") || 
					request.getParameter("email").equals("") || request.getParameter("phone").equals("")){
				
				request.setAttribute("registerMessage","Please fill all fields!");
				request.getRequestDispatcher("/res/jsp/welcome.jsp").forward(request, response);
			}
			else{
				mysqlConnector myConnector = new mysqlConnector();
				myConnector.establishConnection();
				try {
					myConnector.insertUserToDB(request.getParameter("ruser"),request.getParameter("rpassword"),request.getParameter("email")
					,request.getParameter("phone"),"h","default-user.png");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally{
					request.setAttribute("registerMessage","Succesfully registered! Log in to navigate through the site");
					myConnector.destroyConnection();
				}
			
				request.getRequestDispatcher("/res/jsp/welcome.jsp").forward(request, response);
			}
				
		}
		else if(request.getParameter("login") != null)
		{
			String user = request.getParameter("user");
			String psswd = request.getParameter("password");
			
			if(Admin.checkIfAdmin(user, psswd)){
				System.out.println("Permision granted: Admin");
				HttpSession session = request.getSession();
				session.setAttribute("user" , user);
				//setting session to expires in 60 mins
				session.setMaxInactiveInterval(-1);
				
				Cookie userNameCookie = new Cookie("user",user);
				userNameCookie.setMaxAge(-1);
				
				response.addCookie(userNameCookie);
				response.sendRedirect("./res/jsp/admin_page.jsp");
				return;
			}
			System.out.println(user+" "+psswd);
			
			boolean found = false;
			
			mysqlConnector myConnector = new mysqlConnector();
			myConnector.establishConnection();
			try {
				found = myConnector.searchForUser(user, psswd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				myConnector.destroyConnection();
			}

			if(found)
			{
				System.out.println("Permision granted");
				HttpSession session = request.getSession();
				session.setAttribute("user" , user);
				//setting session to expires in 60 mins
				session.setMaxInactiveInterval(-1);
				
				Cookie userNameCookie = new Cookie("user",user);
				userNameCookie.setMaxAge(-1);
				
				response.addCookie(userNameCookie);
				response.sendRedirect("./res/jsp/login_success.jsp");
				return;
				//request.getRequestDispatcher("/res/login_success.jsp").forward(request, response);;
				
			}
			else //user has not been found in db
			{
				//response.sendRedirect("./res/test.jsp");
				//return;
				System.out.println("Permision denied");
				request.setAttribute("loginMessage", "No valid elements for login.Please try again!");
				request.getRequestDispatcher("/res/jsp/welcome.jsp").forward(request, response);
			}
		}
		else{
			request.getRequestDispatcher("/res/jsp/welcome.jsp").forward(request, response);
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
