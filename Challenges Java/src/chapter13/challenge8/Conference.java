package chapter13.challenge8;

public class Conference {

	private String name;
	private int code; 
	private double price;
	
	public Conference(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.code = name.hashCode();
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

}
