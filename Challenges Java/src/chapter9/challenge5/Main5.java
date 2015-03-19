package chapter9.challenge5;

import java.util.Scanner;
public class Main5 {
	public static void main (String[] args) {
		Validator validator = new Validator();
		Scanner scan = new Scanner (System.in);
		boolean correct = false;
		do {
			System.out.print("Insert your password: ");
			String input = scan.nextLine();
			boolean output = validator.validate(input);
			if(output) {
				System.out.println("Your password is correct!!!");	
				correct = true;
			}
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("Your password is incorrect. ");
				sb.append("Remember: \n");
				sb.append("- 	6 characters minimum \n");
				sb.append("- 	at least one upper case \n");
				sb.append("- 	at least one lower case \n");
				sb.append("- 	at least one digit \n");
				sb.append("\n");
				System.out.print(sb.toString());
			}	
		}
		while(correct == false);
		
	}

}
