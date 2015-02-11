public class Main3 {
	public static void main (String[] args) {
		String msg1 = "This program capitalize the sentences in your paragraph";
		InputScanner.showInstructions(msg1);
		String input = InputScanner.getAnswer("Insert Sentence: ");
		String output = Capital.capitalizing(input);
		System.out.println("Your word was tranformated in: "+ output);
	}

}
