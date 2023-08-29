package base;

import java.sql.*;

public class DBA_Connector {

	public static Connection getConnection() {
		Connection connect;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/property_search_system", "root", "root");
			return connect;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
	
//	public boolean authUser(String userName, String password)
//	{
//		try(Connection connect = getConnection())
//		{
//			String authQuery = "SELECT * FROM users WHERE userName = ? AND password = ?";
//			PreparedStatement statement = connect.prepareStatement(authQuery);
//			statement.setString(1, userName);
//			statement.setString(2, password);
//			
//			return statement.executeQuery().next();
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		return false;
//		
//	}
	
	public boolean registerUser(userPojoClass userobj)
	{
		try(Connection connect = getConnection())
		{
			String Query = "INSERT INTO usertable(userName, password) VALUES(?,?)";
			PreparedStatement statement = connect.prepareStatement(Query);
			statement.setString(1, userobj.getUserName());
			statement.setString(2, userobj.getPassword());
			int status = statement.executeUpdate();
			return status>0;
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}

	public boolean authUser(String userName, String password) {
		try(Connection connect = getConnection())
		{
			String authQuery = "SELECT * FROM usertable WHERE userName = ? AND password = ?";
			PreparedStatement statement = connect.prepareStatement(authQuery);
			statement.setString(1, userName);
			statement.setString(2, password);
			
			return statement.executeQuery().next();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
