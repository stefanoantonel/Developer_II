package chapter8.challenge1;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		double area, radius, length, width;

		String r = JOptionPane.showInputDialog("Enter the radius of a circle");
		radius = Double.parseDouble(r);
		area = Shape.calculateArea(radius);
		StringBuilder sb = new StringBuilder();
		sb.append("The area of the circle with radius : ");
		sb.append(radius);
		sb.append(" is: ");
		DecimalFormat fmt = new DecimalFormat("0.00");
		sb.append(fmt.format(area));
		JOptionPane.showMessageDialog(null, sb.toString());
		
		System.out.println("The area of circle with radius of 5 is : "+ Shape.calculateArea(5.0));
		System.out.println("The area of rectangle with width 5 and heigth 3 is : "+ Shape.calculateArea((float)5.0, (float) 3.0));
		System.out.println("The area of cilinder with radius 5 and heigth is 3.8 is : "+ Shape.calculateArea((double)5.0, (double)3.8));
	}

}
