package Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyDAO {
	Connection connection=null;
	public void insert(Property property) throws SQLException {
		try(Connection connection=JDBCConnection.getConnectin()){
			PreparedStatement ps=connection.prepareStatement(
					"INSERT INTO properties(id,floor,price,building,tower,status)"
							+ "VALUES(?,?,?,?,?,?)");
			ps.setInt(1, property.getId());
			ps.setInt(2, property.getFloor());
			ps.setInt(3, property.getPrice());
			ps.setString(4, property.getBuilding());
			ps.setString(5, property.getTower());
			ps.setBoolean(6, property.isStatus());
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void showfull() throws SQLException {
		try(Connection connection=JDBCConnection.getConnectin()){
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM properties");
			ResultSet rs=ps.executeQuery();
			System.out.println("id\t\tfloor\t\tprice\t\tbuilding\ttower\t\tstatus");

			// Condition check
			while (rs.next()) {

				int id = rs.getInt("id");
				int floor= rs.getInt("floor");
				String building = rs.getString("building");
				int price = rs.getInt("price");
				String tower = rs.getString("tower");
				boolean status=rs.getBoolean("status");
				System.out.println(id + "\t\t" + floor
						+ "\t\t" + price
						+ "\t\t" + building
						+ "\t\t" + tower
						+ "\t\t" + status);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void remove(int id) throws SQLException {
		try(Connection connection=JDBCConnection.getConnectin()){
			PreparedStatement ps=connection.prepareStatement("DELETE FROM properties WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}
	public void update(Property property) throws SQLException {
		try(Connection connection=JDBCConnection.getConnectin()){
			
			PreparedStatement ps=connection.prepareStatement(
					"UPDATE properties SET floor=?,price=?,building=?,tower=?"
							+ "WHERE id=?");
			ps.setInt(1, property.getFloor());
			ps.setInt(2, property.getPrice());
			ps.setString(3, property.getBuilding());
			ps.setString(4, property.getTower());
			ps.setInt(5, property.getId());
			//ps.setBoolean(6, property.isStatus());
			ps.executeUpdate();

		}
	}
	public void search(int id) throws SQLException, showError {
		try(Connection connection=JDBCConnection.getConnectin()){
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM properties WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			System.out.println("id\t\tfloor\t\tprice\t\tbuilding\ttower\t\tstatus");

			if(rs.next()!=false) {

				//while (rs.next()) {

					int floor= rs.getInt("floor");
					String building = rs.getString("building");
					int price = rs.getInt("price");
					String tower = rs.getString("tower");
					boolean status=rs.getBoolean("status");
					System.out.println(id + "\t\t" + floor
							+ "\t\t" + price
							+ "\t\t" + building
							+ "\t\t" + tower
							+ "\t\t" + status);
				//}
			}
			else {
				System.out.println("error");
				throw new showError("id not found");
			}
		}

	}
	public void onlysellable() throws SQLException {
		try(Connection connection=JDBCConnection.getConnectin()){
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM properties WHERE status=true");
			ResultSet rs=ps.executeQuery();
			System.out.println("id\t\tfloor\t\tprice\t\tbuilding\ttower\t\tstatus");


				while (rs.next()) {
					int id=rs.getInt("id");
					int floor= rs.getInt("floor");
					String building = rs.getString("building");
					int price = rs.getInt("price");
					String tower = rs.getString("tower");
					boolean status=rs.getBoolean("status");
					System.out.println(id + "\t\t" + floor
							+ "\t\t" + price
							+ "\t\t" + building
							+ "\t\t" + tower
							+ "\t\t" + status);
			}
		}
		
	}
	public void showInRange(int lr,int ur) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection connection=JDBCConnection.getConnectin()){
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM properties WHERE price between ? and ?");
			ps.setInt(1, lr);
			ps.setInt(2, ur);
			ResultSet rs=ps.executeQuery();
			System.out.println("id\t\tfloor\t\tprice\t\tbuilding\ttower\t\tstatus");


				while (rs.next()) {
					int id=rs.getInt("id");
					int floor= rs.getInt("floor");
					int price = rs.getInt("price");
					String building = rs.getString("building");
					String tower = rs.getString("tower");
					boolean status=rs.getBoolean("status");
					System.out.println(id + "\t\t" + floor
							+ "\t\t" + price
							+ "\t\t" + building
							+ "\t\t" + tower
							+ "\t\t" + status);
			}
		}

	}
	public void searchBuilding(String b) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection connection=JDBCConnection.getConnectin()){
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM properties WHERE building=LOWER(?)");
			ps.setString(1, b);
			ResultSet rs=ps.executeQuery();
			System.out.println("id\t\tfloor\t\tprice\t\tbuilding\ttower\t\tstatus");


				while (rs.next()) {
					int id=rs.getInt("id");
					int floor= rs.getInt("floor");
					int price = rs.getInt("price");
					String building = rs.getString("building");
					String tower = rs.getString("tower");
					boolean status=rs.getBoolean("status");
					System.out.println(id + "\t\t" + floor
							+ "\t\t" + price
							+ "\t\t" + building
							+ "\t\t" + tower
							+ "\t\t" + status);
			}
		}

	}
}