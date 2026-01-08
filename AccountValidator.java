package module4.activity5;


public class AccountValidator {
	
	public static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
		
		
		if (accountNumber == null) throw new NullPointerException("Account number cannot be null");
		
		boolean containsNonDigit = false;
		for (char chr: accountNumber.toCharArray()) {
			if (!Character.isDigit(chr)) {
				containsNonDigit = true;
				break;
			}
		}
		
		if (containsNonDigit) {
			throw new InvalidAccountFormatException("Account number must contain only digits");
		}
			
	
		if (accountNumber.length() != 10) throw new InvalidAccountNumberException ("Account number must be exactly 10 digits");
		
		System.out.printf("Valid account number: %s\n", accountNumber);
		
	}
	
	public static void testValidation(String testName, String accountNumber) {
		
		try {
			System.out.println("\n" + testName);
			validateAccountNumber(accountNumber);
			
		} catch (InvalidAccountNumberException | InvalidAccountFormatException | NullPointerException e) {
			System.out.printf("Error: %s\n", e.getMessage());
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("=== Account Number Validation Test ===");
		testValidation("Test 1: Valid account (1234567890)", "1234567890");
		testValidation("Test 2: Too short (123)", "123");
		testValidation("Test 3: Contains letters (12345ABC90)", "12345ABC90");
		testValidation("Test 4: Contains space (1234 567890)", "1234 567890");
		testValidation("Test 5: Null value", null);
		
		
	}

}
