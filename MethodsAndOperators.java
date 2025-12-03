
import java.util.Scanner;

public class MethodsAndOperators {
	
	
	public static int add_nums(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int subtract_nums(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int multiply_nums(int num1, int num2) {
		return num1 * num2;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first integer: ");
		
		int num1 = scanner.nextInt();
		
		System.out.print("Enter second integer: ");
		
		int num2 = scanner.nextInt();
				
		System.out.println("Sum: " + add_nums(num1, num2));
		System.out.println("Difference: " + subtract_nums(num1, num2));
		System.out.println("Product: " + multiply_nums(num1, num2));
		
		scanner.close();

				    
	}
}
