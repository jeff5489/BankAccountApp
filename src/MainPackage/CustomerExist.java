package MainPackage;

// Used in Employee View to check if customer exists

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerExist")
public class CustomerExist extends HttpServlet  implements DBAccessVariables {
	private static final long serialVersionUID = 1L;
       
  
    public CustomerExist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
//		customerExist(firstName, lastName);
		boolean exist = customerExist(firstName, lastName);
        request.setAttribute("customerExist", exist);
        
        PrintWriter out = response.getWriter();
		out.println("CustomerExist Reached.");
		out.println(exist);
        
	}
	
	private boolean customerExist(String firstName, String lastName) {
		boolean answer = false;
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         
	         PreparedStatement ps = conn
	         			.prepareStatement("select * from Customers WHERE FirstName = ? and LastName = ?");
	         
	         ps.setString(1, firstName);
	         ps.setString(2, lastName);
	        
	         final ResultSet resultSet = ps.executeQuery();
	         
	         if (resultSet.next() == false) { 
	        	 answer = false;
	        	 } else 
	        	{ 
	        	do { 
	        		answer = true;
        			} while (resultSet.next()); 
	        	}	         

	         ps.close();
	         conn.close();
	      } catch(SQLException se) {
	         se.printStackTrace();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		System.out.println(answer);
		return answer;
	}
}
