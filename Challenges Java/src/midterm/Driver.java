package midterm;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Driver {

	private static ArrayList<Book> books = new ArrayList<Book>();

	public static void main(String[] args) {
		int choice = -1;

		do {
			choice = ShowMenuJOP();	
			switch (choice) {
				case 0:
					addNewBook();
					break;
				case 1:
					displayBooks();
					break;
				case 2:
					choice = 2;
					break;
				default:
					break;
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

		// Custom button text
		String[] sa = new String[] { 
				"Add new book ", 
				"Display all books",
				"Quit" };

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
			if (!Validator.validateID(id))
				showMessage("Error in ID");
			else {
				showMessage("Insert the Book Description: ");
				String desc = scan.nextLine();
				showMessage("Insert Publisher (MM/DD/YYYY) ");
				String publish = scan.nextLine();
				showMessage("Insert the Book Price: ");
				double price = scan.nextDouble();

				Book book = new Book(id, desc, price, publish);
				books.add(book);
				showMessage("Book created! ");
			}
		}
		catch (Exception e) {
			showMessage(e.getMessage());
		}
	}

	private static void addNewBook() {
		Book book = createBookJOP(); 
		if(book != null) {
			books.add(book);
			showMessage("Book created! ");	
		}
		
	}
	private static Book createBookJOP() {
		try {
			String id = showInputJOP("Insert the Book ID: ");
			if (!Validator.validateID(id)) {
				showMessage("Error in ID");
				return null;
			}
			String desc = showInputJOP("Insert the Book Description: ");
			String publish = showInputJOP("Insert Publisher (MM/DD/YYYY) ");
			if (!Validator.validateDate(publish, '/')) {
				showMessage("Error in Publish Date");
				return null;
			}
			String priceS = showInputJOP("Insert the Book Price: ");
			double price = Double.parseDouble(priceS);

			Book book = new Book(id, desc, price, publish);
			return book;	
		} 
		catch (Exception e) {
			showMessage(e.getMessage());
			return null;
		}
	}

	private static void displayBooks() {
		StringBuilder sb = new StringBuilder();
		sb.append("Books Created: \n");
		if (books.isEmpty())
			sb.append("Book Library is Empty \n");
		for (Book book : books) {
			sb.append(book.toString());
			sb.append("\n");
		}
		showMessage(sb.toString());
	}

	private static void showMessage(String s) {
		System.out.println(s);
		JOptionPane.showMessageDialog(null, s, "", JOptionPane.PLAIN_MESSAGE);
	}

	private static String showInputJOP(String s) {
		return JOptionPane.showInputDialog(null, s);
	}

}
