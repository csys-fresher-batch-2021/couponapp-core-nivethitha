package in.nivethitha.exception;

public class ConnectionException extends RuntimeException {

	private static final long serialVersionUID = 65476809933L;

	public ConnectionException(Exception e, String message) {
		super(message, e);

	}

}
