package property_management_system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class DisplayProperty {

	Statement statement;
	public void displayPro(Connection conn, String pname) {
		try {
			statement = conn.createStatement();
			String QUERY = "SELECT * FROM property where Property_Name = '"+pname+"';";
			ResultSet rs = statement.executeQuery(QUERY);
			System.out.println("***************************************");
			while (rs.next()) {
				// Display values
				System.out.println("PID : " + rs.getInt("Property_Id"));
				System.out.println("Name : " + rs.getString("Property_Name"));
				System.out.println("Area : " + rs.getString("Property_Address"));
				System.out.println("Owner : " + rs.getString("Owner_Name"));
				System.out.println("Buyer : " + rs.getString("Buyer_Name"));
				System.out.println("Price : " + rs.getFloat("Property_Price"));
			}
			System.out.println("\n***************************************\n");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}