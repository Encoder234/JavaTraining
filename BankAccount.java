package module4.activity6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {
	
	private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);
	private static double balance = 10000.0;
	
	
	public static void deposit(double amount) throws InvalidAmountException {
		
		logger.info("Deposit requested: ₱{}", amount);
		if (amount <= 0) { 
			logger.error("Deposit failed: Deposit amount must be positive"); 
			throw new InvalidAmountException("Deposit amount must be positive");
		}
		
		if (amount > 50000) { 
			logger.warn("Large deposit: ₱{} - requires verification", amount);
		}
		
		balance += amount; 
		logger.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
		
	}
	
	
	public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException { 
		logger.info("Withdrawal requested: ₱{}", amount); 
		
		if (amount < 0) { 
			logger.error("Invalid withdrawal amount: ₱{}", amount); 
			throw new InvalidAmountException("Amount cannot be negative."); 
		} 
		
		if (amount > balance) { 
			logger.warn("Insufficient funds. ₱{} available", balance); 
			throw new InsufficientFundsException("Insufficient funds.", balance, amount); 
		} 
		balance -= amount; 
		logger.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance); 
	}
	
	
	public static void runTest(BankTestOperation operation, String operationName) { 
		try { operation.execute(); 
		} catch (InvalidAmountException e) { 
			logger.error("InvalidAmountException during {}: {}", operationName, e.getMessage(), e); 
		} catch (InsufficientFundsException e) { 
			logger.error("InsufficientFundsException during {}: {} (Balance: ₱{}, Requested: ₱{})", operationName, e.getMessage(), e.getBalance(), e.getRequestedAmount(), e); 
		} 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		BankAccount account = new BankAccount(); 
		runTest(() -> account.deposit(5000), "Deposit");
		runTest(() -> account.withdraw(3000), "Withdrawal");
		runTest(() -> account.deposit(-500), "Deposit");
		runTest(() -> account.withdraw(20000), "Withdrawal");
		runTest(() -> account.deposit(60000), "Deposit");	
	}

}
