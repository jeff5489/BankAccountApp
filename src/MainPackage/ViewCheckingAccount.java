package MainPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewCheckingAccount")
public class ViewCheckingAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewCheckingAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = (String) request.getAttribute("firstName");
		String lastName = (String) request.getAttribute("lastName");
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		
//		System.out.println(firstName + " " + lastName);
		System.out.println(CurrentCustomer.getFirstName() + " " + CurrentCustomer.getLastName());
		
		
		response.sendRedirect("ViewAccount.jsp");
	}

}
