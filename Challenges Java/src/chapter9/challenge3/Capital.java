import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.lang.Character;
public class Capital {
	public static String capitalizing (String word) {
		StringTokenizer tokenizer = new StringTokenizer(word,".?");
		StringBuilder sb = new StringBuilder(); 
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken().trim();
			// System.out.println(token);
			StringBuilder builder = new StringBuilder(token);
			
			// char [] parts = token.toCharArray();
			char b = Character.toUpperCase(builder.charAt(0));
			builder.setCharAt(0,b); 
			// System.out.println("part: "+a);
			// builder.charAt(0) = builder.charAt(0);
			
			sb.append(builder.toString());
			sb.append(". ");
			//System.out.println("sb: "+sb.toString());

		}
		return sb.toString();
		
	}
}