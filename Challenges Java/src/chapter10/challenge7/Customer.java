package chapter10.challenge7;

public class Customer extends Person {
	
	private int customerNumber;
	private boolean hasSuscription;
	
	public Customer(String newName, String newPhone, String newAddress, 
			int custNumber, boolean suscription) {
		super(newName, newPhone, newAddress);
		this.customerNumber = custNumber;
		this.hasSuscription = suscription;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public boolean isHasSuscription() {
		return hasSuscription;
	}

	public void setHasSuscription(boolean hasSuscription) {
		this.hasSuscription = hasSuscription;
	}
	
}