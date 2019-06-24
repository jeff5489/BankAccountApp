package MainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet implements DBAccessVariables {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("UpdateCustomer Reached.");
		
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

//	         PreparedStatement st = conn
//	                   .prepareStatement("insert into Customers"
//	                   		+ "values ?, ?, ?"
//	                		+ "where CustomerID = ?");
	         
	         PreparedStatement st = conn
	                   .prepareStatement("UPDATE Customers "
	                   		+ "SET FirstName = ?, LastName = ? "
	                		+ "WHERE CustomerId = ?");
	         
	         		//set FirstName = 'first', LastName='last'
	             
//	         st.setInt(1, Integer.valueOf(request.getParameter("customerID")));
	         st.setString(1, request.getParameter("firstName"));
	         st.setString(2, request.getParameter("lastName"));
	         st.setInt(3, Integer.valueOf(request.getParameter("customerID")));
	         
	         st.executeUpdate();

	         st.close();
	         conn.close();
	      } catch(SQLException se) {
	         se.printStackTrace();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}

	private String CHAR(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
