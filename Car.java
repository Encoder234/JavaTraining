package module2.activity3;

public class Car {
	
	private String model;
	private int year;
	private String color;
	
	public Car() {		
	}

	public Car(String model, int year, String color) {
		this.model = model;
		this.year = year;
		this.color = color;
	}
	
	public String return_car_details() {
		return "model: " + this.model + " year: " + String.valueOf(this.year) + " color: " + this.color;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
}
