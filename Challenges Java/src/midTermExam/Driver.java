package midTermExam;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Driver {
	
	static ArrayList<Truck> trucks = new ArrayList<>();
	
	public static void main(String[] args) {
		int choice = -1;
		showWelcome();
		do {
			choice = showMenuJOP();	
			switch (choice) {
				case 0:
					addTruck();
					break;
				case 1:
					printMaxCap();
					choice = 1;
					break;
				default:
					break;
			}
		} 
		while (choice != 1);
		System.exit(0);

	}
	
	private static Truck createTruck() {
		try {
			String id = showInputJOP("Insert the Truck ID: ");
			String make = showInputJOP("Insert the Make: ");
			String towingS = showInputJOP("Insert the Capacity (towing): ");
			double towing = Double.parseDouble(towingS);
			if(towing <= 0) {
				showMessage("Towing has to be positive");
				return null;
			}
			Truck truck = new Truck(id,make,towing);
			return truck;	
		} 
		catch (NumberFormatException e) {
			showMessage("Towing incorrect");
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	private static void addTruck () {
		Truck t = createTruck();
		if(t != null)
			trucks.add(t);
	}
	
	private static Truck findMaxCap() {
		Truck truckMax = new Truck("-1","-1",0.0);
		for(Truck t : trucks) {
			if(truckMax.getTowingCap() < t.getTowingCap())
				truckMax = t;
		}
		if(truckMax.getID().equals("-1"))
			return null;
		return truckMax;
	}
	
	private static String showInputJOP(String s) {
		return JOptionPane.showInputDialog(null, s);
	}
	
	private static void showMessage(String s) {
		System.out.println(s);
		JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE);
	}
	
	private static int showMenuJOP() {
		String[] sa = new String[] { "Add new Truck ", "Quit" };

		int n = JOptionPane.showOptionDialog(null,
				"Welcome! Please select an option: ", 
				"Menu",
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE,
				null, 
				sa, 
				sa[0]);

		return n;
	}
	
	private static void printMaxCap() {
		Truck truck = findMaxCap();
		if(truck == null) {
			showMessage("There is no Trucks");
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("The truck with the maximum capacity is: \n");
			sb.append(truck.toString());
			showMessage(sb.toString());
		}
	}

	private static void showWelcome() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to the truck system!");
		sb.append("\n");
		sb.append("This system allows you to load trucks and then to know truck");
		sb.append("\n");
		sb.append("with the maximum capaity when you press 'Quit' ");
		showMessage(sb.toString());
	}
}
