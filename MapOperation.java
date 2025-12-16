package module3.activity3;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MapOperation {
	
	static int DislayMenu() {
		Scanner scanner = new Scanner (System.in);
		System.out.println("\nMENU");
		System.out.println("1. Search a product");
		System.out.println("2. Add a product");
		System.out.println("3. Print all products and prices");
		System.out.println("4. Find the cheapest product");
		System.out.println("5. Exit");
		System.out.print("> ");
		return scanner.nextInt();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap<String, Integer> productCatalog = new TreeMap<>();
		Scanner scanner = new Scanner (System.in);
		
		productCatalog.put("Laptop", 50000);
		productCatalog.put("Monitor", 7000);
		productCatalog.put("Mouse", 500);
		productCatalog.put("Keyboard", 1000);
		productCatalog.put("Printer", 6000);

		
		boolean exit = false;
		
		while (!exit) {
			
			int choice = DislayMenu();
			String productName;
			int productPrice;
			
			switch (choice) {
				case 1: System.out.print("Enter product to search: ");
						productName = scanner.nextLine();
						if (productCatalog.containsKey(productName))
							System.out.printf("Product found: %s, Product Price: %d%n", productName, productCatalog.get(productName) );
						else
							System.out.println("Product not found!");
						break;
						
				case 2: System.out.print("Enter product name to add: ");
						productName = scanner.nextLine();
						
						System.out.print("Enter product price: ");
						productPrice = scanner.nextInt();
						scanner.nextLine();
						
						productCatalog.put(productName, productPrice);
						
						System.out.printf("Product added: %s%n", productName);
						break;
				
				case 3: System.out.println("\n=== PRODUCTS LIST =======================");
						int ctr = 1;
						System.out.println("-----------------------------------------");
						System.out.printf("%-5s %-20s %-20s%n", "#", "Product", "Price");
						System.out.println("-----------------------------------------");
						
						for (Map.Entry<String, Integer> product: productCatalog.entrySet()) {
								System.out.printf("%-5d %-20s %-20d%n", ctr, product.getKey(), product.getValue());
								ctr++;
						}
						System.out.println("-----------------------------------------");
						break;
						
				case 4: 				
						Map.Entry<String, Integer> cheapest = null;
						
						for (Map.Entry<String, Integer> product: productCatalog.entrySet()) {
								if (cheapest == null ||  product.getValue() < cheapest.getValue()) {
									cheapest = product;
								}  
						}
						System.out.printf("Chepest Product is %s with Price: %d%n", cheapest.getKey(), cheapest.getValue()  );		
						break;
						
						
				case 5: System.out.println("Exiting...");
						exit = true;
						break;
			}
			
		}

		
		
	}

}
