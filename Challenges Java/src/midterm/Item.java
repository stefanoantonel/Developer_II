package midterm;

public class Item {
	private String id;
	private String description;
	private double price;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		
			this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Item(String id, String description, double price) {
		
			this.id = id;
			this.description = description;
			this.price = price;
		
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: "+ this.id);
		sb.append(" ");
		sb.append("Description: " + this.description);
		sb.append(" ");
		sb.append("Price: $"+ this.price);
		sb.append(" ");
		return sb.toString();
	}

	
}
