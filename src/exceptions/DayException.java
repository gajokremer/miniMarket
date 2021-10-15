package exceptions;

public class DayException extends Exception {

	private static final long serialVersionUID = 1L;
	private String id;

	public DayException(String id) {
		super("ID number doens't correspond this day");
		this.setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
