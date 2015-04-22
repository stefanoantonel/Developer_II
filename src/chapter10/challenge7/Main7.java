package chapter10.challenge7;

public class Main7 {
	public static void main (String[] args) {
		
		String msg1 = "This program will create a Customer who IS A Person.";
		InputScanner.showInstructions(msg1);
		
		String name = InputScanner.getAnswer("Insert Name: ");
		
		String address = InputScanner.getAnswer("Insert Address: ");
		
		String phone = InputScanner.getAnswer("Insert Phone Number: ");
		
		String customerNumber = InputScanner.getAnswer("Insert Customer Number: ");
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
