package chapter8.challenge1;
/**
Create a class with overwrite methods to calculate differents areas. 
*/
public class Shape {
	// Area for circle
	public static Double calculateArea (Double radius) {
		return (Math.PI * (radius * radius));
		// return Math.PI * Math.pow(radius,2);
	}

	// Area for rectangle
	public static float calculateArea (float width, float length) {
		return (width * length);
	}

	// Area for cilinder
	public static Double calculateArea (Double radius, Double heigth) {
		Double result = calculateArea (radius);
		return (result * heigth);
	}
}
