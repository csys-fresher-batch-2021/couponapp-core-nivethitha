package in.nivethitha.exception;

public class InvalidCouponCodeException extends Exception {

	/**
	 * this method is used to display the exception message
	 */
	private static final long serialVersionUID = -1061524916941818526L;

	public InvalidCouponCodeException(String message) {
		super(message);
	}
}
