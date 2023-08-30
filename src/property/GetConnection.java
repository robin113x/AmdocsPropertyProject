package property;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getConnection(Connection con) {
		
		String dbURL = "jdbc:mysql://localhost:3306/property_schema";
		String username = "root";
		String password = "Devansh@2001";
		
		try {
		
			con = DriverManager.getConnection(dbURL, username, password);
		
		} 
		catch (Exception e) {
			
			System.err.println(e);
		
		}
		
		return con;
	}
}

