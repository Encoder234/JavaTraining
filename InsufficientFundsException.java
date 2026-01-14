package module4.activity6;

public class InsufficientFundsException extends Exception {
	

	private double balance; 
	private double requestedAmount; 
	
	public InsufficientFundsException(String message, double balance, double requestedAmount) { 
		super(message); 
		this.balance = balance; 
		this.requestedAmount = requestedAmount; 
	}
	
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	

}
