package module2.activity6;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car(4, "Toyota");
		Truck truck = new Truck(4,"Ford");
		
		car.refuel();
		car.startEngine();
		
		truck.refuel();
		truck.startEngine();
		
		destroyVehicle(car);
		destroyVehicle(truck);
		
	}
	
	public static void destroyVehicle(Vehicle vehicle ) {
		vehicle.destroy();
	}

}
