package chapter9.challenge1;


public class Main1 {
	public static void main (String[] args) {
		// Invert invert = new Invert();
		
		String msg1 = "This program will invert the introduced text";
		InputScanner.showInstructions(msg1);
		String msg2 = "Insert a word";
		String input = InputScanner.getAnswer(msg2);
		String output = Inverter.inverting(input);
		System.out.println("Your word was tranformated in: "+ output);

	}

}
