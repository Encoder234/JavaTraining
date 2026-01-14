package module4.activity7;

@FunctionalInterface
public interface BankTestOperation {
	void execute() throws InvalidAmountException , InsufficientFundsException;
	
}
