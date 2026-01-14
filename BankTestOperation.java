package module4.activity6;

@FunctionalInterface
public interface BankTestOperation {
	void execute() throws InvalidAmountException , InsufficientFundsException;
	
}
