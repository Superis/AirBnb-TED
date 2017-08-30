

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
			   
		if(request.getParameter("saveChanges") != null){
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
			
			response.sendRedirect("./res/jsp/login_success.jsp");
		}
		else response.sendRedirect("./res/jsp/login_success.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
