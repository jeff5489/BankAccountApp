package MainPackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	private int transactionNumber;
	private int accountNumber;
	private double amount;
//	private Date date;
//	private String destination; // enums???
	
	public Transaction(int transactionNumber, int accountNumber, double amount) {
		super();
		this.transactionNumber = transactionNumber;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	
//	public Date getDate() {
//		return date;
//	}
//	public String getDestination() {
//		return destination; 
//	}
	
}