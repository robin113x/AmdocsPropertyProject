package base;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
	private Connection connection;

	public PropertyDAO(Connection connection) {
		this.connection = connection;
	}

	public void addProperty(Property property) throws SQLException {
		String query = "INSERT INTO properties (Prop_id, Prop_location, Prop_price, Prop_name, Prop_type) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, property.getProp_id());
			statement.setString(2, property.getProp_location());
			statement.setFloat(3, property.getProp_price());
			statement.setString(4, property.getProp_name());
			statement.setString(5, property.getProp_type());
			statement.executeUpdate();
		}
	}

	public void updateProperty(Property property) throws SQLException {
		String query = "UPDATE properties SET prop_location=?, prop_price=?, prop_name=?, prop_type=? WHERE prop_id=?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, property.getProp_location());
			statement.setFloat(2, property.getProp_price());
			statement.setString(3, property.getProp_name());
			statement.setString(4, property.getProp_type());
			statement.setInt(5, property.getProp_id());
			statement.executeUpdate();
		}
	}


	public Property propertySearchById(int prop_id) throws SQLException, errorException {
		String query = "SELECT * from properties WHERE prop_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, prop_id);
			try(ResultSet resultSet = statement.executeQuery()){
				if(resultSet.next()) {
					String propLocation = resultSet.getString("prop_location");
					float propPrice = resultSet.getFloat("prop_price");
					String propName = resultSet.getString("prop_name");
					String propType = resultSet.getString("prop_type");
					return new Property(prop_id, propName, propLocation, propPrice,propType);
				}
				else {
					throw new errorException ("id not found");
				}
			}
		}
	}


	public void deleteProperty(int prop_id) throws SQLException {
		String query = "DELETE FROM properties WHERE prop_id=?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, prop_id);
			statement.executeUpdate();
		}
	}

	public List<Property> getAllProperties() throws SQLException {
		List<Property> properties = new ArrayList<>();
		String query = "SELECT * FROM properties";
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				int propId = resultSet.getInt("prop_id");
				String propLocation = resultSet.getString("prop_location");
				float propPrice = resultSet.getFloat("prop_price");
				String propName = resultSet.getString("prop_name");
				String propType = resultSet.getString("prop_type");
				Property property = new Property(propId, propName, propLocation, propPrice,propType);
				properties.add(property);
			}
		}
		return properties;
	}
}
