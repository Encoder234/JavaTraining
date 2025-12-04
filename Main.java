package module2.activity3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car1 = new Car("Toyota Corolla", 2021, "Blue");
		Car car2 = new Car();
		
		car2.setModel("Hinda Civic");
		car2.setYear(2019);
		car2.setColor("Black");
		
		System.out.println("CAR 1 Details: " + car1.return_car_details());
		System.out.println("CAR 2 Details: " + car2.return_car_details());
		
	}

}
