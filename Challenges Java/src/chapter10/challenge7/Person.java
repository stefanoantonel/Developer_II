package chapter10.challenge7;

public class Person {
	private String name;
	private String address;
	private String phone;

	public Person (String newName, String newPhone, String newAddress) {
		this.phone = newPhone;	
		this.name = newName;
		this.address = newAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}