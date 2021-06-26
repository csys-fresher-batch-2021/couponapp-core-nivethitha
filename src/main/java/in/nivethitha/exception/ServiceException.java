package in.nivethitha.exception;

public class ServiceException extends Exception {

	/**
	 * This method is used to display the exception message
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
}
