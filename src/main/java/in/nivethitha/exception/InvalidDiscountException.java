package in.nivethitha.exception;

public class InvalidDiscountException extends Exception {

	/**
	 * This method is used to display the dedicated exception message
	 */
	private static final long serialVersionUID = 1436734202111145299L;

	public InvalidDiscountException(String message) {
		super(message);
	}
}
