package in.nivethitha.exception;

public class EmptyStringException extends Exception {

	/**
	 * This method is used to display the empty string exception message
	 */
	private static final long serialVersionUID = 6162150067268739227L;
	
	public EmptyStringException(String message)
	{
		super(message);
	}

}
