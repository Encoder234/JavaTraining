package module2.activity1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book book = new Book();
		House house = new House();
		Tree tree = new Tree();
		
		System.out.println("Book number of pages = " + String.valueOf(book.return_number_of_pages()));
		System.out.println("HoUse Address is = " + house.return_address());
		System.out.println("Tree heigh is = " + tree.return_height());
	}

}
