package MainPackage;

public abstract class Account {
	private int accountNumber;
	private String accountName;
	private int balance;
	private String ownerFirstName;
	private String ownerLastName;
	

	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerLaststName() {
		return ownerLastName;
	}
	public void setOwnerLaststName(String ownerLaststName) {
		this.ownerLastName = ownerLaststName;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}	
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
