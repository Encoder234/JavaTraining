
import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your age: ");
		
		int age = scanner.nextInt();
		
		if (age < 18) 
			System.out.println("Minor");
		else if (age >= 18 && age <= 59 )
			System.out.println("Adult");
		else if (age >= 60)
			System.out.println("Senior");
		
		scanner.close();
		    
	}
}
