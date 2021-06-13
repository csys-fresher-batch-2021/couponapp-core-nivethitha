package in.nivethitha.exception;

public class InvalidCouponCodeException extends Exception {

	/**
	 * This method is used to display the InvalidCouponCodeException
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCouponCodeException(String message) {
		super(message);
	}

}
