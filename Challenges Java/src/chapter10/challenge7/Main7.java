package chapter10.challenge7;


public class Main7 {
	public static void main (String[] args) {
		// Invert invert = new Invert();
		
		String msg1 = "This program will create a Customer who IS A Person.";
		InputScanner.showInstructions(msg1);
		
		String msg2 = "Insert Name: ";
		String name = InputScanner.getAnswer(msg2);
		
		String msg3 = "Insert Address: ";
		String address = InputScanner.getAnswer(msg3);
		
		String msg4 = "Insert Phone Number: ";
		String phone = InputScanner.getAnswer(msg4);
		
		String msg5 = "Insert Customer Number: ";
		String customerNumber = InputScanner.getAnswer(msg5);
		int cusNumber = -1;
		try {
			cusNumber= Integer.valueOf(customerNumber);
		}
		catch (Exception e) {
			System.out.println("Error with customer Number.");
		}
		
		
		String msg6 = "Do you like to Suscribe? (Y / N): ";
		String suscriptionString = InputScanner.getAnswer(msg6);
		boolean suscription = false;
		if(suscriptionString == "Y" || suscriptionString == "y") {
			suscription = true;
		}
		
		Customer customer = new Customer(name, phone, address, cusNumber, suscription);
		
		
		String output = customer.getName();
		System.out.println("The person name: "+ output);
		
		int intOut = customer.getCustomerNumber();
		System.out.println("The Customer Number: "+ intOut);

	}

}
