package module4.activity2;

public class ATMSystem {

	static double[] accounts = {10000, 15000, 20000};
	
	public static void processWithdrawal(String accountIndex, String amountInput) {
		
		try {
			
			System.out.printf("Account=%s, Amount=%s\n", accountIndex , amountInput);
			Double currBalance = accounts[Integer.parseInt(accountIndex)];
			System.out.printf("Current balance: ₱%.2f\n", currBalance);
			Double withdrawalAmount = Double.parseDouble(amountInput);
			System.out.printf("Withdrawal: ₱%.2f\n", withdrawalAmount);
			if (withdrawalAmount > currBalance) {
				System.out.printf("Insufficient funds! Cannot withdraw ₱%.2f\n", withdrawalAmount);
			} else {
				System.out.printf("New balance: ₱%.2f\n", currBalance - withdrawalAmount);
				System.out.println("Withdrawal successful!");
			}
			
		} catch (NumberFormatException e) { 
			System.out.println("Error: Invalid input\nPlease enter valid numbers.");
		} catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println("Error: Account not found\nInvalid account index.");
		} catch (Exception e) {  System.out.println("Transaction failed"); e.printStackTrace(); }
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("=== ATM Withdrawal System ===\n");
		
		System.out.println("--- Test 1: Valid Withdrawal ---");
		processWithdrawal("1","5000");
		
		System.out.println("\n--- Test 2: Invalid Account Index ---");
		processWithdrawal("abc","5000");
		
		System.out.println("\n--- Test 3: Account Not Found ---");
		processWithdrawal("10","5000");

		System.out.println("\n--- Test 4: Insufficient Funds ---");
		processWithdrawal("1","20000");
		
		
		
		System.out.println("\n=== All tests completed! ===");
	}

}
