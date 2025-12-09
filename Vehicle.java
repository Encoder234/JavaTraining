package module2.activity6;

abstract class Vehicle {

	private int numberOfWheels;
	private String brand;
	
	Vehicle(int numberOfWheels, String brand) {
		this.numberOfWheels = numberOfWheels;
		this.brand = brand;
	}
	
	abstract void startEngine();
	
	void destroy() {
		System.out.println("Destroying Vehicle");
	}
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
