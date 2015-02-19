package chapter10.challenge1;
public class Main1 {
	public static void main (String[] args) {
		// Invert invert = new Invert();
		
		String msg1 = "This will save the information of an Employee";
		InputScanner.showInstructions(msg1);
		
		String name = InputScanner.getAnswer("Insert a Name: ");
		
		String number = InputScanner.getAnswer("Insert a Employee Number: ");
		
		String date = InputScanner.getAnswer("Insert a Hire Date (MM/DD/YYYY) : ");
		
		String shiftS = InputScanner.getAnswer("Insert the shift: 1 (day) or 2 (night): ");
		int shift = Integer.valueOf(shiftS);
		
		String payRateS = InputScanner.getAnswer("Insert the hourly pay rate: ");
		float payRate = Float.valueOf(payRateS);
		
		ProductionWorker productionWorker = new ProductionWorker(name, number, date,shift,payRate);
		
		System.out.println("\n");
		System.out.println("You create a Production Worker!!! \n ");
		System.out.println(productionWorker.toString());
	
	}

}
