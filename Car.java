package module2.activity6;

public class Car extends Vehicle implements Refuelable {

	
	Car(int numberOfWheels, String brand) {
		super(numberOfWheels, brand);
	}


	@Override
	public void refuel() {
		// TODO Auto-generated method stub
		System.out.println("Car is refueling...");
	}

	@Override
	void startEngine() {
		// TODO Auto-generated method stub
		System.out.println("Car engine is starting...");
	}

	@Override
	void destroy() {
		System.out.println("Destroying car...");
	}
}
