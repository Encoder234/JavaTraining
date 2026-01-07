package module4.activity1;

public class BankAccount {
	
	public static String getAccountName(String accountNumber) {
		
		if (accountNumber.equals("ACC-001")) return "Juan Dela Cruz";
		else if (accountNumber.equals("ACC-002")) return "Maria Santos";
		else 
			return null;
	}
	
	public static void testCase(String accountNumber) {
		try {
			
			System.out.printf("\nLooking up account: %s\n", accountNumber );
			String name = getAccountName(accountNumber);
			System.out.printf("Account holder: %s\n", name.toUpperCase() );
				
		} catch (NullPointerException e) {
			System.out.println("Error: Account not found!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Bank Account Name Display ===");
		testCase("ACC-001"); 
		testCase("ACC-999"); 	
		System.out.println("\n=== Program completed successfully! ===");	
	}

}
