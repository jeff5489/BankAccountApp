package MainPackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
	private double amount;
	private Date date;
	private String destination; // enums???
	
	public Transaction(double amount, String date, String destination) {
		super();
		this.amount = amount;
		Date date1 = new Date();
		this.date = date1;
		this.destination = destination;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public Date getDate() {
		return date;
	}
	public String getDestination() {
		return destination;
	}
	
}
