
import java.util.Scanner;

public class WhatIsYourNameVirgilio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("What is you name? ");
		
		String userInput = scanner.nextLine();
		
		System.out.println("Hello " + userInput + "!");
		
		scanner.close();

				    
	}
}
