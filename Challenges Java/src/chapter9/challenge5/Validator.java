import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Validator {
	public boolean validate (String password) {
		
		StringBuilder errorMessage = new StringBuilder();
		boolean passUpper = false;
		boolean passLower = false;  
		boolean passDigit = false;
		boolean passLength = false; 
		int pLength = password.length();
		int i = 0;

		if( pLength > 5) { passLength = true; }
		// else { 
		// 	errorMessage.append("Your password must contain");
		// 	errorMessage.append("at least 6 characters long. ");
		// }

		// while (i <= pLength) {
		for(char letter : password.toCharArray()) {
			if(Character.isLowerCase(letter)) 
				passLower = true; 
			if(Character.isUpperCase(letter)) 
				passUpper = true;
			if(Character.isDigit(letter)) 
				passDigit = true;  
		}

		if(passUpper && passLower && passDigit && passLength) {
			return true; 
		}
		else {
			return false; 
		}
	}
}