package property;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class DisplayProperty {

	Statement statement;
	
	public void displayPro(Connection con, String pname) {
		
		try {
			
			statement = con.createStatement();
			String QUERY = "SELECT * FROM property where Property_Name='" +pname +"';";
			ResultSet rs = statement.executeQuery(QUERY);
			System.out.println("____________________________________________");
			
			while (rs.next()) {
				System.out.println("Property ID : " + rs.getInt("Property_ID"));
				System.out.println("Property Name : " + rs.getString("Property_Name"));
				System.out.println("Proeprty Area : " + rs.getString("Property_Area"));
				System.out.println("Property Price : " + rs.getFloat("Property_Price"));
				System.out.println("Property Owner : " + rs.getString("Property_Owner"));
				System.out.println("Property Buyer : " + rs.getString("Property_Buyer"));
			}
			
			System.out.println("\n___________________________________________\n");
		
		} 
		
		catch (Exception e) {
			
			System.out.println(e);
		
		}
		
	}
}