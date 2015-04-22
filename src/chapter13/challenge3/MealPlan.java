package chapter13.challenge3;

public class MealPlan {
	private String name;
	private int code; 
	private double price;
	private String measureUnit;
	
	public MealPlan(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.code = name.hashCode();
		this.setMeasureUnit("Per Semester");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
}
