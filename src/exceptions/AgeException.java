package exceptions;

public class AgeException extends Exception {

	private static final long serialVersionUID = 1L;
	private String type;
	
	public AgeException(String type) {
		super("This person's age is below 18");
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
