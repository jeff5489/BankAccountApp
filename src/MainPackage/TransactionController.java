package MainPackage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet implements DBAccessVariables  {
    public TransactionController() {
        super();
    }
    
    private static final long serialVersionUID = 1L;
    private TransactionDAO transactionDAO;
 
    public void init() {
 
        transactionDAO = new TransactionDAO(DB_URL, USER, PASS);
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertTransaction(request, response);
                break;
            case "/random":
                showNewForm(request, response);
                break;
            case "/list":
            	listTransactions(request, response);
                break;
            default:
            	System.out.println("Default in switch statement reached.");
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void listTransactions(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	        List<Transaction> listTransaction = transactionDAO.listAllTransactions();
	        request.setAttribute("listTransaction", listTransaction);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerInterface.jsp");
	        dispatcher.forward(request, response);	
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionForm.jsp");
	        dispatcher.forward(request, response);
		
	}

	private void insertTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int transactionNumber = Integer.valueOf(request.getParameter("transactionNumber"));
        int accountNumber = Integer.valueOf(request.getParameter("accountNumber"));
        double amount = Float.parseFloat(request.getParameter("amount"));
 
        Transaction newTransaction = new Transaction(transactionNumber, accountNumber, amount);
        transactionDAO.insertTransaction(newTransaction);
        response.sendRedirect("list");
	}

}
