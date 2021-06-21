package in.nivethitha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.nivethitha.exception.ConnectionException;

public class ConnectionUtil {
	private ConnectionUtil() {
		// Default constructor
	}

	private static final String DRIVER_CLASS_NAME = System.getenv("spring.datasource.driver-class-name");
	private static final String DB_URL = System.getenv("spring.datasource.url");
	private static final String DB_USERNAME = System.getenv("spring.datasource.username");
	private static final String DB_PASSWORD = System.getenv("spring.datasource.password");

	public static Connection getConnection() throws ConnectionException {
		Connection connection;
		try {
			Class.forName(DRIVER_CLASS_NAME);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			Logger.trace(e);
			throw new ConnectionException(e, "Unable to get Connection");
		}
		return connection;
	}

	/**
	 * This method is used to close the connection of ResultSet connection and
	 * prepared statement Method overloading
	 * @param con
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {

				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

			Logger.trace(e);
		}
	}
	
}
