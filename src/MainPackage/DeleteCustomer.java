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

@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet implements DBAccessVariables {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("DeleteCustomer Reached.");
		
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

	         PreparedStatement st = conn
	                   .prepareStatement("delete from Customers where CustomerID = ?");
	         
	         st.setInt(1, Integer.valueOf(request.getParameter("customerID")));
	         
	         st.executeUpdate();
	         
	         PreparedStatement st2 = conn
	                   .prepareStatement("delete from Accounts where AccountNumber = ?");
	         
	         st2.setInt(1, Integer.valueOf(request.getParameter("accountNumber")));
	         
	         st2.executeUpdate();

	         st.close();
	         st2.close();
	         conn.close();
	      } catch(SQLException se) {
	         se.printStackTrace();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}

}
