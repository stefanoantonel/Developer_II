package chapter10.challenge1;

public class Employee {
	private String name;
	private String number;
	private String hireDate;

	public Employee (String newName, String newNumber, String newHireDate) {
		
		if (Validator.validate(newNumber)) {
			this.number = newNumber;	
			this.name = newName;
			this.hireDate = newHireDate;
		}
		else {
			System.out.println("ERROR creating employee");
		}
		
	}
	public String getName() {
		return this.name;
	}
	public String getNumber() {
		return this.number;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("You create an employee named: " + this.getName());
		sb.append("\n");
		sb.append("The employee number is: " + this.getNumber());
		sb.append("\n");
		sb.append("The hire date was: " + this.getHireDate());
		sb.append("\n");
		return sb.toString();
	}
}