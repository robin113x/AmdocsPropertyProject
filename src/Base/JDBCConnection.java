package Base;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
//	public static Connection con;
	public static Connection getConnectin() {
		Connection con;
		try
		{  
//			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test_db","root","pass@word1");  
			//here sonoo is database name, root is username and password  
			
			return con;
		}
		catch(Exception e)
		{ System.out.println(e);
		}  
		return null;
	}

	public static Connection getUser() {
		Connection con;
		try
		{  
//			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test_db","root","pass@word1");  
			//here sonoo is database name, root is username and password  
			
			return con;
		}
		catch(Exception e)
		{ System.out.println(e);
		}  
		return null;
	}
}