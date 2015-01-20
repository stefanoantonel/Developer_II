package chapter8.challenge1;

public class Shape {
	public static Double calculateArea (Double radius) {
		return Math.PI * (radius * radius);
	}
	public static float calculateArea (float width, float length) {
		return width * length;
	}
	public static Double calculateArea (Double radius, Double heigth) {
		Double result = calculateArea (radius);
		return result * heigth;
	}
}
