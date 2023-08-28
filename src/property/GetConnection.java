package property;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getConnection(Connection conn) {
		String dbURL = "jdbc:mysql://localhost:3306/propms";
		String username = "root";
		String password = "Devansh@2001";
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
//			if (conn != null) {
//				System.out.println("\t yooo");
//			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return conn;
	}
}

