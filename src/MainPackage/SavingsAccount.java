package MainPackage;

public class SavingsAccount extends Account{
	
	public SavingsAccount(String accountName) {
		super();
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	private double interestRate;
}
