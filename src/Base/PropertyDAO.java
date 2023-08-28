package Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyDAO {
	Connection connection=null;
	public void insert(Property property) throws SQLException {
		try(Connection connection=JDBCConnection.getConnection()){
			PreparedStatement ps=connection.prepareStatement(
					"INSERT INTO properties(id,floor,PropertiesCol,building,tower)"
							+ "VALUES(?,?,?,?,?)");
			ps.setInt(1, property.getId());
			ps.setInt(2, property.getFloor());
			ps.setString(3, property.getPropertiesCol());
			ps.setString(4, property.getBuilding());
			ps.setString(5, property.getTower());
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void showfull() throws SQLException {
		try(Connection connection=JDBCConnection.getConnection()){
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM properties");
			ResultSet rs=ps.executeQuery();
			System.out.println("id\t\tfloor\t\tPropertiesCol\tbuilding\ttower");

			// Condition check
			while (rs.next()) {

				int id = rs.getInt("id");
				int floor= rs.getInt("floor");
				String col = rs.getString("building");
				String building = rs.getString("PropertiesCol");
				String tower = rs.getString("tower");
				System.out.println(id + "\t\t" + floor
						+ "\t\t" + col
						+ "\t\t" + building
						+ "\t\t" + tower);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void remove(int id) throws SQLException {
		try(Connection connection=JDBCConnection.getConnection()){
			PreparedStatement ps=connection.prepareStatement("DELETE FROM properties WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}
	public void update(Property property) throws SQLException {
		try(Connection connection=JDBCConnection.getConnection()){
			PreparedStatement ps=connection.prepareStatement(
					"UPDATE properties SET floor=?,PropertiesCol=?,building=?,tower=?"
							+ "WHERE id=?");
			ps.setInt(1, property.getFloor());
			ps.setString(2, property.getPropertiesCol());
			ps.setString(3, property.getBuilding());
			ps.setString(4, property.getTower());
			ps.setInt(5, property.getId());
			ps.executeUpdate();

		}
	}
	public void search(int id) throws SQLException, showError {
		try(Connection connection=JDBCConnection.getConnection()){
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM properties WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			System.out.println("id\t\tfloor\t\tPropertiesCol\tbuilding\ttower");

			if(rs.next()!=false) {

				while (rs.next()) {

					int floor= rs.getInt("floor");
					String col = rs.getString("building");
					String building = rs.getString("PropertiesCol");
					String tower = rs.getString("tower");
					System.out.println(id + "\t\t" + floor
							+ "\t\t" + col
							+ "\t\t" + building
							+ "\t\t" + tower);
				}
			}
			else {
				System.out.println("error");
				throw new showError("id not found");
			}
		}

	}
}