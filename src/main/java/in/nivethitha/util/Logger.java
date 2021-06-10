package in.nivethitha.util;

public class Logger {
	private Logger() {
		//Default constructor
	}
	/**
	 * This log method is for capture the corresponding log records
	 * @param obj
	 */
	public static void log(Object obj) {
		System.out.println(obj);
	}
	
	/**
	 * This method is for trace out the exception
	 * @param e
	 */
	public static void trace(Exception e) {
		e.printStackTrace();
	}

}
