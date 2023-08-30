package allproperty;
import java.sql.Connection;
import java.sql.Statement;
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
						"INSERT INTO attributes(propertyID,property_name,price,area,validity) VALUES(?, ?, ?, ?, ?)");
				preparedStatement.setInt(1,nppty.getPropertyid());
				preparedStatement.setString(2,nppty.getProperty_name());
				preparedStatement.setInt(3,nppty.getPrice());
				preparedStatement.setString(4,nppty.getArea());
				preparedStatement.setString(5,nppty.getValid());


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
				do	{
					int id = resultset.getInt(1);
					String name = resultset.getString(2);
					int price = resultset.getInt(3);
					String area = resultset.getString(4);
					String valid = resultset.getString(5);
					System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area + " Validity: " +valid );
				}while(resultset.next()) ;
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
				preparedstatement1.setString(5,uppty.getValid());
				preparedstatement1.setInt(6,uppty.getPropertyid());
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
				String valid = resultset.getString("validity");
				System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area + " Validity: "+ valid);
			}

		}catch(validation ex) {
			System.out.println(ex);
		}
		connection.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}

	}



	public static void searcharea(property sppty){
		try {Connection connection = db_connection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM attributes WHERE area = ?");
		preparedStatement.setString(1, sppty.getArea());	
		ResultSet resultset = preparedStatement.executeQuery();
		try {
			if(!resultset.next()) {
				throw new validation("Property is not available in the given area ");
			}

			else{
				do {
					int id = resultset.getInt(1);
					String name = resultset.getString(2);
					int price = resultset.getInt(3);
					String area = resultset.getString(4);
					String valid = resultset.getString("validity");
					System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area + " Validity: "+ valid);

				}while(resultset.next());}

		}catch(validation ex) {
			System.out.println(ex);
		}
		connection.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}

	}



	public static void searchbyvalidity() {
		try {Connection connection = db_connection.getConnection();
		Statement statement = null;
		statement = connection.createStatement();
		String query=	"SELECT * FROM attributes WHERE validity= 'yes'";
		ResultSet resultset = statement.executeQuery(query);
		try {
			if(!resultset.next()) {
				throw new validation("No property is available.");//if there is no data in the table
			}
			else {

				do	 {
					int id = resultset.getInt(1);
					String name = resultset.getString(2);
					int price = resultset.getInt(3);
					String area = resultset.getString(4);
					String valid = resultset.getString(5);
					System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area + " Validity: " +valid );
				}while(resultset.next());
			}}catch(validation ex) {
				System.out.println(ex);
				connection.close();

			}	}catch(SQLException e) {
				e.printStackTrace();
			}
	}



	public static void searchpptybyprice(Integer maxpriced,Integer minpriced){
		try {Connection connection = db_connection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM attributes WHERE price  BETWEEN ? and ?");
		preparedStatement.setInt(1, minpriced);	
		preparedStatement.setInt(2, maxpriced);	

		ResultSet resultset = preparedStatement.executeQuery();
		try {
			if(!resultset.next()) {
				throw new validation("Property with given ID is not available ");
			}

			else{
				do{
					int id = resultset.getInt(1);
					String name = resultset.getString(2);
					int price = resultset.getInt(3);
					String area = resultset.getString(4);
					String valid = resultset.getString(5);
					System.out.println("Property ID: " + id + " Property Name: " + name + " Property Price: "+ price + " Area: "+ area + " Validity: "+ valid);
				}while(resultset.next()) ;
				connection.close();

			}
		}catch(validation ex) {
			System.out.println(ex);
		}}catch(SQLException e) {
			e.printStackTrace();
		}

	}



	public static void registration(user_ rppty) throws Exception {
		try{Connection connection = db_connection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"INSERT INTO user(name,email_id,pswd) VALUES(?, ?, ?)");
		preparedStatement.setString(1,rppty.getName());
		preparedStatement.setString(2,rppty.getEmail_id());
		preparedStatement.setString(3,rppty.getPswd());
		preparedStatement.executeUpdate();

		connection.close();
		Reg.main(null);


		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public static void login(user_ rppty) throws Exception {
		try{Connection connection = db_connection.getConnection();


		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM user WHERE email_id=? AND pswd= ?");
		preparedStatement.setString(1,rppty.getEmail_id());	
		preparedStatement.setString(2,rppty.getPswd());	
		ResultSet resultset = preparedStatement.executeQuery();
		try {
			if(!resultset.next()) {
				System.out.println("Invalid credentials");
				Reg.login();
				//throw new validation("User not available. Enter valid user credentials");

			}
			else{

				System.out.println("Login success");

				Main.menu();
				connection.close();
			}
		}catch(validation ex) {
			System.out.println(ex);
		}}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

















