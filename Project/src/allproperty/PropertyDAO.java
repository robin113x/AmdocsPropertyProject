package allproperty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class PropertyDAO{



	public static void insertppty(property nppty) {
		try{Connection connection = db_connection.getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM attributes WHERE propertyID = ?");
		preparedstatement.setInt(1, nppty.getPropertyid());	//checking whether property with same id is available
		ResultSet resultset = preparedstatement.executeQuery();
		try {
			if(resultset.next()) {
				throw new validation("Already a property is avilable with given property ID. Enter valid Property ID ");
			}
			else {

				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO attributes(propertyID,property_name,price,area) VALUES(?, ?, ?, ?)");
				preparedStatement.setInt(1,nppty.getPropertyid());
				preparedStatement.setString(2,nppty.getProperty_name());
				preparedStatement.setInt(3,nppty.getPrice());
				preparedStatement.setString(4,nppty.getArea());

				preparedStatement.executeUpdate();
			}}catch(validation ex) {
				System.out.println(ex);
			}
		connection.close();


		}catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public static void displayppt() {
		try {Connection connection = db_connection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM attributes");
		ResultSet resultset = preparedStatement.executeQuery();
		try {
			if(!resultset.next()) {
				throw new validation("No property is available.");//if there is no data in the table
			}
			else {

				while(resultset.next()) {
					int id = resultset.getInt(1);
					String name = resultset.getString(2);
					int price = resultset.getInt(3);
					String area = resultset.getString(4);
					System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area);
				}
			}}catch(validation ex) {
				System.out.println(ex);
				connection.close();

			}	}catch(SQLException e) {
				e.printStackTrace();
			}


	}

	public static void deleteppty(property dppty) {//check id is there or not
		try { Connection connection = db_connection.getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(
				"SELECT * FROM attributes WHERE propertyID = ?");
		preparedstatement.setInt(1, dppty.getPropertyid());	
		ResultSet resultset = preparedstatement.executeQuery();
		try {
			if(!resultset.next()) {
				throw new validation("No property available with the given Property ID ");
			}
			else {

				PreparedStatement preparedStatement = connection.prepareStatement(
						"DELETE FROM attributes WHERE propertyID=?");
				preparedStatement.setInt(1,dppty.getPropertyid());
				preparedStatement.executeUpdate();
			}}catch(validation ex) {
				System.out.println(ex);
			}


		connection.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}


	}

	public static void updateppty(property uppty) {
		try { Connection connection = db_connection.getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM attributes WHERE propertyID = ?");
		preparedstatement.setInt(1, uppty.getPropertyid());	
		ResultSet resultset = preparedstatement.executeQuery();
		try {
			if(!resultset.next()) {
				throw new validation("Property cannot be updated as property with given property ID is not available");
			}
			else {


				PreparedStatement preparedstatement1 = connection.prepareStatement(
						"UPDATE attributes SET propertyID = ? , property_name = ?, price = ?, area= ? WHERE propertyID = ?");

				preparedstatement1.setInt(1,uppty.getPropertyid());
				preparedstatement1.setString(2,uppty.getProperty_name());
				preparedstatement1.setInt(3,uppty.getPrice());
				preparedstatement1.setString(4,uppty.getArea());
				preparedstatement1.setInt(5,uppty.getPropertyid());

				preparedstatement.executeUpdate();
			}}catch(validation ex) {
				System.out.println(ex);
			}


		connection.close();




		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	public static void searchppty(property sppty) throws validation{
		try {Connection connection = db_connection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM attributes WHERE propertyID = ?");
		preparedStatement.setInt(1, sppty.getPropertyid());	
		ResultSet resultset = preparedStatement.executeQuery();
		try {
			if(!resultset.next()) {
				throw new validation("Property with given ID is not avilable ");
			}


			else{
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				int price = resultset.getInt(3);
				String area = resultset.getString(4);
				System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area);
			}

		}catch(validation ex) {
			System.out.println(ex);
		}
		connection.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	public static void searchpptybyprice(Integer priced){
		try {Connection connection = db_connection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM attributes WHERE price <= ?");
		preparedStatement.setInt(1, priced);	
		ResultSet resultset = preparedStatement.executeQuery();
		try {
			if(!resultset.next()) {
				throw new validation("Property with given ID is not avilable ");
			}


			else{


				while(resultset.next()) {
					int id = resultset.getInt(1);
					String name = resultset.getString(2);
					int price = resultset.getInt(3);
					String area = resultset.getString(4);
					System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area);
				}
				connection.close();

			}
		}catch(validation ex) {
			System.out.println(ex);
		}}catch(SQLException e) {
			e.printStackTrace();
		}

	}


}

















