package base;

import java.sql.*;

public class DBA_Connector {

	public static Connection getConnection() {
		Connection connect;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/property_search_system", "root", "root");
			return connect;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
