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
	
	public Vehicle(String iD, String make) {
		super();
		ID = iD;
		this.make = make;
	} 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(ID);
		sb.append(".\n");
		sb.append("Make: ");
		sb.append(make);
		sb.append(".\n");
		return sb.toString();
	}
}
