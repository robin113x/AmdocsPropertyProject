package property;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search {
	
	Statement statement;
	
	public void searchPro(Connection con, String area) {
		
		try {
			
			statement = con.createStatement();
			String QUERY = "SELECT * FROM property where Property_Area = '" +area + "';";
			ResultSet rs = statement.executeQuery(QUERY);
			
			System.out.println("__________________________________________");
						
			while (rs.next()) {
				// To display the values
				System.out.println("Property ID : " + rs.getInt("Property_ID"));
				System.out.println("Property Name : " + rs.getString("Property_Name"));
				System.out.println("Property Area : " + rs.getString("Property_Area"));
				System.out.println("Property Price : " + rs.getFloat("Property_Price"));
				System.out.println("Property Owner : " + rs.getString("Property_Owner"));
				System.out.println("Property Buyer : " + rs.getString("Property_Buyer"));
				System.out.println("\n________________________________________\n");
			}
					
		} 
		catch (Exception e) {
			
			System.out.println(e);
		
		}
	}
}