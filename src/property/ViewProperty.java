package property;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewProperty {

	public void viewProperty(Connection con) {		
		
		try {
		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM property");
			System.out.printf("%-5s %-20s %-15s %-10s %-20s %-20s%n", "ID", "Name", "Area", "Price", "Owner Name","Buyer Name");
			
			while (rs.next()) {
				
				int id = rs.getInt("Property_ID");
				String name = rs.getString("Property_Name");
				String area = rs.getString("Property_Area");
				Float price = rs.getFloat("Property_Price");
				String owner = rs.getString("Property_Owner");
				String buyer = rs.getString("Property_Buyer");
				System.out.printf("%-5d %-20s %-15s %-10.2f %-20s %-20s%n", id, name, area, price, owner, buyer);
			
			}
		
		} 
		
		catch (Exception e) {
			
			System.out.println("SQL exception occured" + e);
		
		}
	}
}