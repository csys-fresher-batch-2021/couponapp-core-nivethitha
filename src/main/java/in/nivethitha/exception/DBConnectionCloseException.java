package in.nivethitha.exception;

public class DBConnectionCloseException extends Exception {
		private static final long serialVersionUID = 654274293L;

		public DBConnectionCloseException(Exception e, String message) {
			super(message);
		}
}
