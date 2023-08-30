package property_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getConnection(Connection conn) {
		String dbURL = "jdbc:mysql://localhost:3306/vinay";
		String username = "root";
		String password = "Password@1";
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
		} catch (Exception e) {
			System.err.println(e);
		}
		return conn;
	}
}

