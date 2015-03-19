package midterm;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Driver {

	private static ArrayList<Book> books = new ArrayList<Book>();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice = 0;
		
		do {
			ShowMenu();
			try {
				scan = new Scanner(System.in);
				String election = scan.nextLine(); 
				if( !election.equals("") ){
					choice = Integer.parseInt(election); 
					switch (choice) {
						case 1:
							CreateBook();
							break;
						case 2:
							DisplayBooks();
							break;
						case 3:
							choice = 3;
							break;
						default: 
							break;
					}
				}	
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		while (choice != 3);
	}
		
	private static void ShowMenu() {
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
	
	private static void CreateBook() {
		try {
			scan = new Scanner(System.in);
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
	
	private static void DisplayBooks() {
		StringBuilder sb = new StringBuilder();	
		for(Book book : books) {
			sb.append(book.toString());
			sb.append("\n");
		}
		showMessage("Books Created: ");
		showMessage(sb.toString());
	}
	
	private static void showMessage(String s) {
		System.out.println(s);
		//		JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
	}
}
