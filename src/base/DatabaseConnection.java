package base;
import java.sql.DriverManager;
import java.sql.Connection;


public class DatabaseConnection {

	public static Connection getConnection() {
		Connection con;
		try
		{   
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/property_search_system","root","thahaxaina98@");  

			//here Property_search_system is database name, root is username and password  

			if(con!=null) {
				System.out.println("connection Established");
			}
			return con;
		}
		catch(Exception e)
		{ System.out.println(e);
		}  
		return null;
	}
}
