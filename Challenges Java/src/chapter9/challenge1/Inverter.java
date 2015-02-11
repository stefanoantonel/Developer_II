import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Inverter {
	public static String inverting (String word) {
		StringBuilder invertedWord = new StringBuilder();
		for (int i = word.length() - 1 ; i >= 0; i--) {
			invertedWord.append(word.charAt(i));
		}
		return invertedWord.toString();
	}
}