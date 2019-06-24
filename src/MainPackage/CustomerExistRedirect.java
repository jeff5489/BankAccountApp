package MainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerExistRedirect")
public class CustomerExistRedirect extends HttpServlet  implements DBAccessVariables {
	private static final long serialVersionUID = 1L;
	
	Customer currentCustomer = new Customer();

    public CustomerExistRedirect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
 		String lastName = request.getParameter("lastName");
 		CurrentCustomer.setFirstName(firstName);
 		CurrentCustomer.setLastName(lastName);
		

		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         
	         PreparedStatement ps = conn
	         			.prepareStatement("select * from Customers WHERE FirstName = ? and LastName = ?");
	         
	         ps.setString(1, firstName);
	         ps.setString(2, lastName);
	         System.out.println(firstName);
	         System.out.println(lastName);
	         final ResultSet resultSet = ps.executeQuery();
	         
	         //   Problem Below !!!!!!!!!!!!!!!!!!!!
	        
	         if (resultSet.next()) { 
//	        	 response.sendRedirect("CustomerInterface.jsp");
	        		
	     		request.setAttribute("firstName", firstName);
	     		request.setAttribute("lastName", lastName); 
	    		RequestDispatcher dispatcher2 = request.getRequestDispatcher("CustomerInterface.jsp");
	    		dispatcher2.forward(request, response);
	        	 
	        	 
	        	 
	        	 
	         } else  { 
	        	 System.out.println("Your name doesn't exist in the database. Set up name in Employee interface first.");
	         }
	         
	         //   Problem Above !!!!!!!!!!!!!!!!!!!!
	         
	         ps.close();
	         conn.close();
	      } catch(SQLException se) {
	         se.printStackTrace();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }	
	}
	
	
	
	
	
	
	
	
	
	
//	private void customerExist(String firstName, String lastName,  HttpServletResponse response) {
//		try {
//	         Class.forName("com.mysql.cj.jdbc.Driver");
//
//	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//	         
//	         PreparedStatement ps = conn
//	         			.prepareStatement("select * from Customers WHERE FirstName = ? and LastName = ?");
//	         
//	         ps.setString(1, firstName);
//	         ps.setString(2, lastName);
//	         System.out.println(firstName);
//	         System.out.println(lastName);
//	         final ResultSet resultSet = ps.executeQuery();
//	         
//	         //   Problem Below !!!!!!!!!!!!!!!!!!!!
//	        
//	         if (resultSet.next()) { 
//	        	 response.sendRedirect("CustomerInterface.jsp");
//	         } else  { 
//	        	 System.out.println("Your name doesn't exist in the database. Set up name in Employee interface first.");
//	         }
//	         
//	         //   Problem Above !!!!!!!!!!!!!!!!!!!!
//	         
//	         ps.close();
//	         conn.close();
//	      } catch(SQLException se) {
//	         se.printStackTrace();
//	      } catch(Exception e) {
//	         e.printStackTrace();
//	      }
//	}
}