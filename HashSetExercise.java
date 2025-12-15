package module3.activity2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HashSetExercise {
	
	static int DislayMenu() {
		Scanner scanner = new Scanner (System.in);
		System.out.println("\nMENU");
		System.out.println("1. Search a product");
		System.out.println("2. Add a product");
		System.out.println("3. print all products and count");
		System.out.println("4. Exit");
		System.out.print("> ");
		return scanner.nextInt();
	}
	
	
	public static void main(String[] args) { 
		
		Set<String> products = new HashSet<>();
		Scanner scanner = new Scanner (System.in);
		
		products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");
		
		boolean exit = false;
		
		while (!exit) {
			
			int choice = DislayMenu();
			String product;
			
			switch (choice) {
				case 1: System.out.print("Enter product to search: ");
						product = scanner.nextLine();
						if (products.contains(product))
							System.out.printf("Product found: %s%n", product);
						else
							System.out.println("Product not found!");
						break;
						
				case 2: System.out.print("Enter product name to add: ");
						product = scanner.nextLine();
						products.add(product);
						System.out.printf("Product added: %s%n", product);
						break;
				
				case 3: System.out.println("\n=== PRODUCTS LIST ============");
						int ctr = 1;
						for (String prod : products) {
							System.out.printf("%d. %s%n", ctr, prod);
							ctr++;
						}
						System.out.printf("Total unique products: %d%n", products.size());
						System.out.println("==============================");
						break;
						
				case 4: System.out.println("Exiting...");
						exit = true;
						break;
			}
			
		}
		
				
	}
	

	
	
	

}
