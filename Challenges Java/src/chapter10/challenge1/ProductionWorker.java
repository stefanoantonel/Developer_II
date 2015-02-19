package chapter10.challenge1;
public class ProductionWorker extends Employee {
	
	private int shift; 
	//to divide the day (1) and night (2).
	private float hourlyPayRate;
	
	
	public ProductionWorker(String newName, String newNumber, 
			String newHireDate, int newShift, float newPayRate) {
		super(newName, newNumber, newHireDate);
		
		this.shift = newShift;
		this.hourlyPayRate = newPayRate;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("The shift is: " + this.shift);
		sb.append("\n");
		sb.append("The hourly pay rate is: " + this.hourlyPayRate);
		sb.append("\n");
		return sb.toString();
	}
}