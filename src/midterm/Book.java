package midterm;

import java.io.IOException;


public class Book extends Item {

	private String publisher; 
	
	public Book(String id, String description, double price, String pub)  throws IOException {
		super(id, description, price);
		this.publisher = pub;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Publisher: "+ this.publisher);
		sb.append(" ");
		return sb.toString();
	}

}
