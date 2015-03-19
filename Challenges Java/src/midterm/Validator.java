package midterm;

public class Validator {
	public static boolean validateID (String number) {
		try {
			int pLength = number.length();
			int i = 0;
			char [] letters = number.toCharArray();

			if( pLength != 7) {
				return false;
			}
			
			while(i < 3) {	
				if(Character.isLowerCase(letters[i])) {
					letters[i] = Character.toUpperCase(letters[i]);	
				}
				else { 
					if(!Character.isUpperCase(letters[i])) {
						return false;
					}
				}
				i++;
			}

			if(letters[i] != '-') {
				return false;
			}
			i++;
			
			while(i < 3) {	
				if(! Character.isDigit(letters[i])) {
					return false;
				}
				i++;
			}
			
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean validateDate(String date, char sep) {
		int pLength = date.length();
		int i = 0;
		char [] letters = date.toCharArray();

		if( pLength != 10) {
			return false;
		}
		
		while(i <= 1) {	
			if(!Character.isDigit(letters[i]))
				return false;	
			i++;
		}

		if(letters[i] != sep) {
			return false;
		}
		i++;
		
		while(i <= 4) {	
			if(!Character.isDigit(letters[i]))
				return false;	
			i++;
		}

		if(letters[i] != sep) {
			return false;
		}
		i++;

		while(i <= 9) {	
			if(!Character.isDigit(letters[i]))
				return false;	
			i++;
		}
		
		return true;
	}
}