package in.nivethitha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.nivethitha.exception.ConnectionException;
import in.nivethitha.exception.DBConnectionCloseException;
public class ConnectionUtil {
	private ConnectionUtil() {
		
	}
		private static String driverClass = "org.postgresql.Driver";
		private static String url = "jdbc:postgresql://localhost/coupon_db";
		private static String userName = "postgres";
		private static String password = "postgres";

		public static Connection getConnection() throws ConnectionException {
			Connection connection;
			try {
				Class.forName(driverClass);
				connection = DriverManager.getConnection(url, userName, password);
			} catch (Exception e) {
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
		public static void close(ResultSet rs, PreparedStatement ps, Connection con) throws DBConnectionCloseException {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
				throw new DBConnectionCloseException(e, "Unable to close connection");
			}
		}
		public static void main(String[] args) throws ConnectionException {
			
				getConnection();
			
		}
		
		
}
