package in.nivethitha.exception;

public class InvalidPurchaseAmountException extends Exception {

	/**
	 * This method is used to display the dedicated exception message 
	 */
	private static final long serialVersionUID = -2128311106254487301L;

	public InvalidPurchaseAmountException(String message) {
		super(message);
	}
}
