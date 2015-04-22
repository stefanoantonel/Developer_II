package chapter10.challenge1;


public class Validator {
	public static boolean validate (String number) {
		
		int pLength = number.length();
		int i = 0;
		char [] letters = number.toCharArray();

		if( pLength != 5) {
			return false;
		}
		
		while(i < 3) {	
			if(! Character.isDigit(letters[i])) {
				return false;
			}
			i++;
		}

		if(letters[i] != '-') {
			
			return false;
		}
		
		i++;
		
		if(Character.isLowerCase(letters[i])) {
		
			letters[i] = Character.toUpperCase(letters[i]);
			return true;
		}
		else {
			if(Character.isUpperCase(letters[i])) {
				return true;
			}
		}

		return false;
	}
}