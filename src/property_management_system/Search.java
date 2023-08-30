package property_management_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search {
	
	Statement statement;
	public void searchPro(Connection conn, String area) 
	{
		try {
			statement = conn.createStatement();
			
			String QUERY = "SELECT * FROM property where Property_Address= '" +area + "';";
			ResultSet rs = statement.executeQuery(QUERY);
			System.out.println("***************************************");
			
			/*ResultSet temp =rs;
			if (temp.next() == false) {
				System.out.println("No Property ... Thank You....");
			}*/
			
			while (rs.next()) {
				// Display values
				System.out.println("PID : " + rs.getInt("Property_ID"));
				System.out.println("Name : " + rs.getString("Property_Name"));
				System.out.println("Area : " + rs.getString("Property_Address"));
				System.out.println("Owner : " + rs.getString("Owner_Name"));
				System.out.println("Buyer : " + rs.getString("Buyer_Name"));
				System.out.println("Price : " + rs.getFloat("Property_Price"));
				System.out.println("\n***************************************\n");
			}
					} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}