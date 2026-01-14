package module4.activity8;

@FunctionalInterface
public interface BankTestOperation {
	void execute() throws InvalidAmountException , InsufficientFundsException;
	
}
