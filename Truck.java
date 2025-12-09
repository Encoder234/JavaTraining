package module2.activity6;

public class Truck extends Vehicle implements Refuelable {
	
	Truck(int numberOfWheels, String brand) {
		super(numberOfWheels, brand);
	}

	@Override
	public void refuel() {
		// TODO Auto-generated method stub
		System.out.println("Truck is refueling...");
	}

	@Override
	void startEngine() {
		// TODO Auto-generated method stub
		System.out.println("Truck engine is starting...");
	}
	
	@Override
	void destroy() {
		System.out.println("Destroying truck...");
	}
	
}
