package chapter8.challenge3;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			String witdthS =  JOptionPane.showInputDialog("Insert the Witdth: ");
			Double width = Double.valueOf(witdthS);
			
			Double heigth = Double.valueOf(JOptionPane.showInputDialog("Insert Heigth"));
			Double cost = Double.valueOf(JOptionPane.showInputDialog("Insert Cost of Carpet"));
			
			RoomDimension roomDim = new RoomDimension(width, heigth);
			RoomCarpet carpet = new RoomCarpet(roomDim, cost);
			Double price = carpet.calculatePrice();
			System.out.println("The price is : "+price);
			JOptionPane.showMessageDialog(null, "The price is : "+ price);
		}
		catch (Exception e) {
			System.out.println("Parameters error");
			JOptionPane.showMessageDialog(null, "Parameters Error");
		}
	}
}
