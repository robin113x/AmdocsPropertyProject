package property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class DeleteProperty {
	
	public void deleteProp(Connection con,Scanner sc) {

		try {

			System.out.print("Enter the Property ID to delete: ");
			int delete = sc.nextInt();
			
			String sql = "SELECT * FROM property WHERE Property_ID = " +delete + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				System.out.println("\nProperty ID is:- " +rs.getInt("Property_ID"));
				System.out.println("Property Name is:- " +rs.getString("Property_Name"));
				System.out.println("Property Area is:- " +rs.getString("Property_Area"));
				System.out.println("Property Price is:- " +rs.getFloat("Property_Price"));
				System.out.println("Property Owner is:- " +rs.getString("Property_Owner"));
				System.out.println("Property Buyer is:- " +rs.getString("Property_Buyer"));
			}
			
			System.out.println("Are you Sure you want to delete this? \n1.Yes\t\t2.No");
			System.out.println("Enter your choice in numerical :- ");
			int opt = sc.nextInt();
			
			if(opt==1) {
				
				String deleteQuery = "DELETE FROM property WHERE Property_ID = ?";
				PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
				preparedStatement.setInt(1, delete);
				
				int rowsAffected = preparedStatement.executeUpdate();
				
				if (rowsAffected > 0) {
					System.out.println(rowsAffected + " row(s) deleted successfully. ");

				} 
				else {
					System.out.println("No matching property found.");

				}
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
