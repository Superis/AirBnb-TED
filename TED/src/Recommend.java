

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaClasses.*;
/**
 * Servlet implementation class Recommend
 */
@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recommend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = 100;
        
        // R^n
        int n = 3;
        
        int stages = 2;
        int buckets = 4;
        
        // Produce some vectors in R^n
        Random r = new Random();
        double[][] vectors = new double[count][];
        for (int i = 0; i < count; i++) {
            vectors[i] = new double[n];
            
            for (int j = 0; j < n; j++) {
                vectors[i][j] = r.nextGaussian();
            }
	        }
	    try {
	        LSHSuperBit lsh = new LSHSuperBit(stages, buckets, n);
	        
	        // Compute a SuperBit signature, and a LSH hash
	        for (int i = 0; i < count; i++) {
	            double[] vector = vectors[i];
	            int[] hash = lsh.hash(vector);
	            for (double v : vector) {
	                System.out.printf("%6.2f\t", v);
	            }
	            System.out.print(hash[0]);
	            System.out.print("\n");
	        }
	    } catch (Exception ex) {
	        Logger.getLogger(Recommend.class.getName()).log(Level.SEVERE, null, ex);
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
