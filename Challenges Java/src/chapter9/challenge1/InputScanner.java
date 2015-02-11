import java.util.Scanner;
public class InputScanner {
	static Scanner scan = new Scanner (System.in);
	public static void showInstructions(String msg) {
		System.out.println("\n----------------- WELCOME ---------------------");
		System.out.println("| "+msg+". |");
		System.out.println("-------------------------------------------------");
	}
	public static String getAnswer(String msg) {
		System.out.print("\n" + msg + ": ");
		String text = scan.nextLine();
		return text;
	}
}