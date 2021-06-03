package in.nivethitha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.nivethitha.exception.ConnectionException;

public class ConnectionUtil {
	private ConnectionUtil() {

	}

	private static final String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static final String url = System.getenv("spring.datasource.url");
	private static final String userName = System.getenv("spring.datasource.username");
	private static final String password = System.getenv("spring.datasource.password");

	public static Connection getConnection() throws ConnectionException {
		Connection connection;
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConnectionException(e, "Unable to get Connection");
		}
		System.out.println("connection created");
		return connection;
	}

	/**
	 * This method is used to close the connection of Resultset connection and
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

			e.printStackTrace();
		}
	}

	
}
