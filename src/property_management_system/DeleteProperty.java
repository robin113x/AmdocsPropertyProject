package property_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteProperty {

	public void deleteProp(Connection conn,Scanner scc) {

		try {

			System.out.print("Enter the ID of the property to delete: ");
			int propertyIdToDelete = scc.nextInt();
			String deleteQuery = "DELETE FROM property WHERE Property_ID = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, propertyIdToDelete);
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println(rowsAffected + " row(s) deleted successfully. ");

			} else {
				System.out.println("No matching property found.");

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
