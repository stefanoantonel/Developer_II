package chapter9.challenge3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.lang.Character;
public class Capital {
	public static String capitalizing (String word) {
		StringTokenizer tokenizer = new StringTokenizer(word,".?");
		StringBuilder sb = new StringBuilder(); 
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken().trim();
			// showMessage(token);
			StringBuilder builder = new StringBuilder(token);
			
			// char [] parts = token.toCharArray();
			char b = Character.toUpperCase(builder.charAt(0));
			builder.setCharAt(0,b); 
			// showMessage("part: "+a);
			// builder.charAt(0) = builder.charAt(0);
			
			sb.append(builder.toString());
			sb.append(". ");
			//showMessage("sb: "+sb.toString());

		}
		return sb.toString();
		
	}
}