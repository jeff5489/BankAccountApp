package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TransactionDAO {
	
	private String url;
    private String userName;
    private String pass;
    private Connection connection;
    
	public TransactionDAO(String url, String userName, String pass) {
//		super();
		this.url = url;
		this.userName = userName;
		this.pass = pass;
	}
    
	protected void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connection = DriverManager.getConnection(
                                        url, userName, pass);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    
    public boolean insertTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO Transactions (TransactionNumber, AccountNumber, Amount) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, transaction.getTransactionNumber());
        statement.setInt(2, transaction.getAccountNumber());
        statement.setDouble(3, transaction.getAmount());
        
        
//      private int transactionNumber;
//    	private int accountNumber;
//    	private double amount;
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<Transaction> listAllTransactions() throws SQLException {
        List<Transaction> listTransaction = new ArrayList<>();
         
        String sql = "SELECT * FROM Transactions";
         
        connect();
         
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int transactionNumber = resultSet.getInt("transactionNumber");
            int accountNumber = resultSet.getInt("accountNumber");
            double amount = resultSet.getDouble("amount");
            
            Transaction transaction = new Transaction(transactionNumber, accountNumber, amount);
            listTransaction.add(transaction);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listTransaction;
    }
    

}