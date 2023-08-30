package property_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchPriceRange {
	
	public void searchPrice(Connection con, int price1, int price2) {
		try{
			String query1 = "SELECT * FROM property where Price BETWEEN " +price1 + " AND " +price2 +";";
			PreparedStatement ps = con.prepareStatement(query1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Property id is:- " +rs.getInt("Property_ID"));
				System.out.println("Property name is:- " +rs.getString("Property_Name"));
				System.out.println("Property area is:- " +rs.getString("Property_Address"));
				System.out.println("Proeprty Owner is:- " +rs.getString("Owner_Name"));
				System.out.println("Property Buyer is:- " +rs.getString("Buyer_Name"));
				System.out.println("Property price is:- " +rs.getFloat("Property_Price"));
				System.out.println("____________________________________________________");
			}
		}
		catch(Exception e) {
			
		}
	}
}
