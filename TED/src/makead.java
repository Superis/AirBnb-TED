

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class makead
 */
@WebServlet("/makead")
public class makead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String role=request.getParameter("str");
		if (role==null) {
			System.out.println("CRAP");
			return;
		}
		if (!(role.equals("ok"))){
			request.setAttribute("errormessage","Only Hosts can submit new ads!!!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/res/jsp/login_success.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/res/jsp/make_ad.jsp");
			rd.forward(request, response);
			//response.sendRedirect("./res/jsp/make_ad.jsp");
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
