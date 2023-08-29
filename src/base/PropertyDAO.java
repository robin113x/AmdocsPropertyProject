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
		String query = "INSERT INTO properties (Prop_id, Prop_location, Prop_price, Prop_name, Prop_type, Prop_status) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, property.getProp_id());
			statement.setString(2, property.getProp_location());
			statement.setFloat(3, property.getProp_price());
			statement.setString(4, property.getProp_name());
			statement.setString(5, property.getProp_type());
			statement.setString(6,property.getProp_status());
			statement.executeUpdate();
		}

	}

	// to update the property on the database over the existing property
	public void updateProperty(Property property) throws SQLException {
		String query = "UPDATE properties SET prop_location=?, prop_price=?, prop_name=?, prop_type=?, prop_status=? WHERE prop_id=?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, property.getProp_location());
			statement.setFloat(2, property.getProp_price());
			statement.setString(3, property.getProp_name());
			statement.setString(4, property.getProp_type());
			statement.setInt(5, property.getProp_id());
			statement.setString(6,property.getProp_status());
			statement.executeUpdate();
		}

	}

	// to search the data from database based on the prop_id
	public Property propertySearchByIdAndStatus(int prop_id, String status) throws SQLException, errorException {
		String query = "SELECT * from properties WHERE prop_id=? AND not prop_status=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, prop_id);
			statement.setString(2, status);
			try(ResultSet resultSet = statement.executeQuery()){
				if(resultSet.next()) {
					String propLocation = resultSet.getString("prop_location");
					float propPrice = resultSet.getFloat("prop_price");
					String propName = resultSet.getString("prop_name");
					String propType = resultSet.getString("prop_type");
					String propStatus = resultSet.getString("prop_Status");
					return new Property(prop_id, propName, propLocation, propPrice,propType,propStatus);
				}
				else {
					throw new errorException ("id not found");
				}
			}
		}
	}

	// to search the property based on the parameter on max_price and min_price 
	public List<Property> propertySearchByPrice(int min_price, int max_price) throws SQLException {
		List<Property> priceR = new ArrayList<>();
		String query = "SELECT * From properties WHERE prop_price BETWEEN ? AND ?";
		try (PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1,min_price);
			statement.setInt(2,max_price);
			try(ResultSet resultSet = statement.executeQuery()){
				while(resultSet.next()) {
					int propID = resultSet.getInt("prop_id");
					String propLocation = resultSet.getString("prop_location");
					float propPrice = resultSet.getFloat("prop_price");
					String propName = resultSet.getString("prop_name");
					String propType = resultSet.getString("prop_type");
					String propStatus = resultSet.getString("prop_Status");
					Property property = new Property(propID, propName, propLocation, propPrice,propType,propStatus);
					priceR.add(property);
				}
			}
		}
		return priceR;
	}

	// to delete the data of specific id from database
	public void deleteProperty(int prop_id) throws SQLException {
		String query = "DELETE FROM properties WHERE prop_id=?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, prop_id);
			statement.executeUpdate();
		}
	}

	// to get all the data available on the database 
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
				String propStatus = resultSet.getString("prop_Status");
				Property property = new Property(propId, propName, propLocation, propPrice,propType,propStatus);
				properties.add(property);
			}
		}
		return properties;
	}

	public boolean registerUser(String username, String password) throws SQLException {
		String query= "INSERT INTO login (Username, password) VALUES(?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, username);
			statement.setString(2, password);
			int insertRow = statement.executeUpdate();
			if(insertRow > 0) {
				return true;
			}
			else {
					return false;
				}
			}
		
		}

		public boolean logInUser(String loginUsername, String loginPassword) throws SQLException {
			String query = "SELECT * FROM login WHERE username = ? and password = ?";
			try(PreparedStatement statement = connection.prepareStatement(query)){
				statement.setString(1, loginUsername);
				statement.setString(2, loginPassword);
				try(ResultSet resultSet = statement.executeQuery()){
					return resultSet.next();
				}
				catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}
