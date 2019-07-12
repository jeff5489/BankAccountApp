package MainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Driver;

@WebServlet("/GetCustomers")
public class GetCustomers extends HttpServlet {
	
	final String DB_URL="jdbc:mysql://localhost/bankAccountApp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	final String USER = "root";
	final String PASS = "pass";
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

    public GetCustomers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

	         Statement stmt = conn.createStatement();
	         String sql = "SELECT CustomerId, FirstName, LastName FROM Customers;";
	         ResultSet rs = stmt.executeQuery(sql);
 
	         while(rs.next()){
	            int customerID  = rs.getInt("CustomerId");
	            String firstName = rs.getString("FirstName");
	            String lastName = rs.getString("LastName");

	            out.println("Customer ID: " + customerID);
	            out.println("First Name: " + firstName);
	            out.println("Last Name: " + lastName);
	            out.println("-----------------------------------------");
	         }

	         rs.close();
	         stmt.close();
	         conn.close();
	      } catch(SQLException se) {
	         se.printStackTrace();
	      } catch(Exception e) {
	         e.printStackTrace();
	      } 
	}
}
