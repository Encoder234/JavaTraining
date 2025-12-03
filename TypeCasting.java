
import java.util.Scanner;

public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your age: ");
		
		String userInput = scanner.nextLine();
		
		
		System.out.println("Your age as int: " + Integer.parseInt(userInput));
		System.out.println("Your age as double: " + Double.parseDouble(userInput));
		
		scanner.close();

				    
	}
}
