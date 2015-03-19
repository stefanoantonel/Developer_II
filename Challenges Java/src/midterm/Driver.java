package midterm;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Driver {

	private static ArrayList<Book> books = new ArrayList<Book>();
	
	
	public static void main(String[] args) {
		int choice = -1;
		
		do {
//			showMenu();
			choice = ShowMenuJOP();
			try {
//				Scanner scan = new Scanner(System.in);
//				String election = scan.nextLine(); 
//				if( !election.equals("") ){
//					choice = Integer.parseInt(election); 
				
				switch (choice) {
					case 0:
//						createBook();
						createBookJOP();
						break;
					case 1:
//						displayBooks();
						displayBooks();
						break;
					case 2:
						choice = 2;
						break;
					default: 
						break;
				}
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		while (choice != 2);
		System.exit(0);
	}
		
	private static void showMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome! Please select an option: ");
		sb.append("\n");
		sb.append("1) Add new book ");
		sb.append("\n");
		sb.append("2) Display all books");
		sb.append("\n");
		sb.append("3) Quit");
		sb.append("\n");
		showMessage(sb.toString());
	}
	
	private static int ShowMenuJOP() {
		
		//Custom button text
		String[] sa = new String[] { 
				"Add new book ", 
				"Display all books", 
				"Quit"
				};
		
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
	
	private static void createBook() {
		try {
			Scanner scan = new Scanner(System.in);
			showMessage("Insert the Book ID: ");
			String id = scan.nextLine();
			if(!Validator.validate(id))
				showMessage("Error in ID");
			else {
				showMessage("Insert the Book Description: ");
				String desc = scan.nextLine();
				showMessage("Insert Publisher (MM/DD/YYYY) ");
				String publish = scan.nextLine();
				showMessage("Insert the Book Price: ");
				double price = scan.nextDouble();
			
				Book book = new Book(id,desc, price, publish);
				books.add(book);
				showMessage("Book created! ");
			}
		}
		catch(Exception e) {
			showMessage(e.getMessage());
		}
	}
	
	private static void createBookJOP() {
		try {
//			Scanner scan = new Scanner(System.in);
			String id = showMessageJOP("Insert the Book ID: ");
			if(!Validator.validate(id))
				showMessage("Error in ID");
			else {
				String desc = showMessageJOP("Insert the Book Description: ");
//				String desc = scan.nextLine();
				String publish = showMessageJOP("Insert Publisher (MM/DD/YYYY) ");
//				scan.nextLine();
				String priceS = showMessageJOP("Insert the Book Price: ");
				double price = Double.parseDouble(priceS);
//				scan.nextDouble();
			
				Book book = new Book(id,desc, price, publish);
				books.add(book);
				showMessage("Book created! ");
			}
		}
		catch(Exception e) {
			showMessage(e.getMessage());
		}
	}
	
	private static void displayBooks() {
		StringBuilder sb = new StringBuilder();	
		sb.append("Books Created: \n");
		for(Book book : books) {
			sb.append(book.toString());
			sb.append("\n");
		}
		showMessage(sb.toString());
	}
	
	private static void showMessage(String s) {
//		System.out.println(s);
		
		JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE);
		
	}
	private static String showMessageJOP(String s) {
		return JOptionPane.showInputDialog(null, s);	
	}
	
	
}
