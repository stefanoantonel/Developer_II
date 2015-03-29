package midTermExam;

public class Truck extends Vehicle {

	private double towingCap;
	
	public Truck(String iD, String make, double towing) {
		super(iD, make);
		this.towingCap = towing;
		// TODO Auto-generated constructor stub
	}

	public double getTowingCap() {
		return towingCap;
	}

	public void setTowingCap(double towingCap) {
		this.towingCap = towingCap;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		
		sb.append("Towing Capacity: ");
		sb.append(this.getTowingCap());
		sb.append(".");
		return sb.toString();
	}
}













