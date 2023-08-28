package allproperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection{

	private static final String url = "jdbc:mysql://localhost:3306/property_search";
	private static final String user ="root";
	private static final String password ="root1234";


	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, user, password);
	}
}
