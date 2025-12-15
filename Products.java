package module3.activity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products {

	public static void main(String[] args) {
	
		List<String> products = new ArrayList<>();
		
		products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");
				
		System.out.println("ALL Products");
		for (int i = 0 ; i < products.size(); i++) {
			System.out.printf("%s. %s%n",i+1, products.get(i));
			
		}
		
		products.add("Webcam");
		products.remove("Mouse");
		
		System.out.println("\nALL Products");
		for (int i = 0 ; i < products.size(); i++) {
			System.out.printf("%s. %s%n",i+1, products.get(i));
			
		}
		
		Scanner scanner = new Scanner (System.in);
		System.out.print("\nEnter the product name to search: ");
		String searchProduct = scanner.nextLine();
		
		if(products.contains(searchProduct))
			System.out.printf("Product found: %s%n", searchProduct);
		else
			System.out.printf("Product %s NOT Found %n", searchProduct);
		
		
		System.out.print("\nEnter the product name to search: ");
		searchProduct = scanner.nextLine();
		
		if(products.contains(searchProduct))
			System.out.printf("Product found: %s%n", searchProduct);
		else
			System.out.printf("Product %s NOT Found %n", searchProduct);
		
	
		

	}
}
