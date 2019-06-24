package MainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet implements DBAccessVariables {
	private static final long serialVersionUID = 1L;
       
    public AddCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("AddCustomer Reached.");
		
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

	         PreparedStatement st = conn
	                   .prepareStatement("insert into Customers values(?, ?, ?)");
	         
	         st.setInt(1, Integer.valueOf(request.getParameter("customerID")));
	         st.setString(2, request.getParameter("firstName"));
	         st.setString(3, request.getParameter("lastName"));
	         
	         st.executeUpdate();
	         
	         
	         PreparedStatement st2 = conn
	                   .prepareStatement("insert into Accounts values(?, ?, ?, ?)");
	         
	         st2.setInt(1, Integer.valueOf(request.getParameter("accountNumber")));
	         st2.setString(2, request.getParameter("accountName"));
	         st2.setString(3, request.getParameter("firstName"));
	         st2.setString(4, request.getParameter("lastName"));
	         
	         st2.executeUpdate();

//	         String accountNumber = request.getParameter("accountNumber");
//	         String accountName = request.getParameter("accountName");
//	         String firstName = request.getParameter("firstName");
//	         String lastName = request.getParameter("lastName");
	         
	         st.close();
	         conn.close();
	      } catch(SQLException se) {
	         se.printStackTrace();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
}
