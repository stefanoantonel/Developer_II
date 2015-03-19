package midTermExam;

public class Vehicle {
	private String ID;
	private String make;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getMark() {
		return make;
	}
	
	public void setMark(String mark) {
		this.make = mark;
	}
	
	public Vehicle(String iD, String mark) {
		super();
		ID = iD;
		this.make = mark;
	} 
	public String toString() {
		return ("ID: " + ID + " Mark: " + make);
	}
}
