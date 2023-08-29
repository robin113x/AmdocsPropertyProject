package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.exceptions.PropertyNotModifiableException;

public class DOA {

	Connection connection = null;

	// inserting record
	public void insert(propertyEnt obj) {
		try (Connection connection = DBA_Connector.getConnection()) {
			String insertQuery = "INSERT INTO property (propId, propName, area, cost, ownerName, buyerName) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, obj.getPropId());
			statement.setString(2, obj.getPropName());
			statement.setString(3, obj.getArea());
			statement.setInt(4, obj.getCost());
			statement.setString(5, obj.getOwnerName());
			statement.setString(6, obj.getBuyerName());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// updating record
	public void update(propertyEnt obj) {
		try (Connection connection = DBA_Connector.getConnection()) {
			String updateQuery = "UPDATE property SET propName = ?, area = ?, cost = ?, ownerName = ?, buyerName = ?"
					+ "WHERE propID = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setString(1, obj.getPropName());
			statement.setString(2, obj.getArea());
			statement.setInt(3, obj.getCost());
			statement.setString(4, obj.getOwnerName());
			statement.setString(5, obj.getBuyerName());
			statement.setInt(6, obj.getPropId());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// showing all record
	public List<propertyEnt> getAllDetails() {

		List<propertyEnt> detailsList = new ArrayList<>();

		try (Connection connection = DBA_Connector.getConnection()) {
			String displayQuery = "SELECT * FROM property";
			PreparedStatement statement = connection.prepareStatement(displayQuery);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				propertyEnt obj = new propertyEnt(0, null, null, 0, null, null);
				obj.setPropId(rs.getInt("propId"));
				obj.setPropName(rs.getString("propName"));
				obj.setArea(rs.getString("area"));
				obj.setCost(rs.getInt("cost"));
				obj.setOwnerName(rs.getString("ownerName"));
				obj.setBuyerName(rs.getString("buyerName"));

				detailsList.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detailsList;

	}

	// deleting record
	public void deletProp(int propid) {
		try (Connection connection = DBA_Connector.getConnection()) {
			String deleteQuery = "DELETE FROM property WHERE propId = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, propid);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// searching record
	public void searchDetails(int propID) throws PropertyNotFoundException {
		try (Connection connection = DBA_Connector.getConnection()) {
			String searchQuery = "SELECT * FROM property WHERE propId = ?";
			PreparedStatement statement = connection.prepareStatement(searchQuery);
			statement.setInt(1, propID);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				System.out.println("Property Id: " + rs.getInt("propId"));
				System.out.println("Property Name: " + rs.getString("propName"));
				System.out.println("Property Area: " + rs.getString("area"));
				System.out.println("Property Cost: " + rs.getInt("cost"));
				System.out.println("Property Owner: " + rs.getString("ownerName"));
				System.out.println("Property Buyer: " + rs.getString("buyerName"));
			} else {
				throw new PropertyNotFoundException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// searching by the price range
	public void searchPropByPriceRange(int propmin, int propmax) throws PropertyNotFoundException {
		try (Connection connection = DBA_Connector.getConnection()) {
			String searchByPriceRangeQuery = "SELECT * FROM property WHERE cost > ? AND cost < ?";
			try (PreparedStatement statement = connection.prepareStatement(searchByPriceRangeQuery)) {
				statement.setInt(1, propmin);
				statement.setInt(2, propmax);

				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next() == true) {
						System.out.println("Property Id: " + rs.getInt("propId"));
						System.out.println("Property Name: " + rs.getString("propName"));
						System.out.println("Property Area: " + rs.getString("area"));
						System.out.println("Property Cost: " + rs.getInt("cost"));
						System.out.println("Property Owner: " + rs.getString("ownerName"));
						System.out.println("Property Buyer: " + rs.getString("buyerName"));

						while (rs.next()) {
							System.out.println("Property Id: " + rs.getInt("propId"));
							System.out.println("Property Name: " + rs.getString("propName"));
							System.out.println("Property Area: " + rs.getString("area"));
							System.out.println("Property Cost: " + rs.getInt("cost"));
							System.out.println("Property Owner: " + rs.getString("ownerName"));
							System.out.println("Property Buyer: " + rs.getString("buyerName"));
						}
					} else {
						throw new PropertyNotFoundException();
					}
//	                while (rs.next()) {
//	                    System.out.println("Property Id: " + rs.getInt("propId"));
//	                    System.out.println("Property Name: " + rs.getString("propName"));
//	                    System.out.println("Property Area: " + rs.getString("area"));
//	                    System.out.println("Property Cost: " + rs.getInt("cost"));
//	                    System.out.println("Property Owner: " + rs.getString("ownerName"));
//	                    System.out.println("Property Buyer: " + rs.getString("buyerName"));
//	                }
				}
			}
		} catch (SQLException e) {
			// Handle the exception gracefully
			System.err.println("An error occurred while searching properties: " + e.getMessage());
			e.printStackTrace(); // Print the exception trace
		}
	}

}
