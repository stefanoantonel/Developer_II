package midterm;

public class ValidatorException extends Throwable {
	private String error;

	public ValidatorException(String error) {
		super();
		this.error = error;
	} 
	
	public String getMesaage() {
		return error;
	}
}
