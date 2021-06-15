package in.nivethitha.exception;

public class InvalidDateException extends Exception {

	/**
	 * This method used to display the exception message
	 */
	private static final long serialVersionUID = 6179061853533791142L;

	public InvalidDateException(String message) {
		super(message);
	}
}
