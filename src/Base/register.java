package Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class register {
	private static Scanner scanner=new Scanner(System.in);
	public static void suca() throws showError {
		int choice;
		
		System.out.println("1: SignUp");
		System.out.println("2: Login");
		System.out.println("3: Update property");
		choice=scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter username");
			String username=scanner.next();
			System.out.println("Enter password");
			String pass=scanner.next();
			signin(username,pass);
			break;
		case 2:

			System.out.println("Enter username");
			String usernamee=scanner.next();
			System.out.println("Enter password");
			String passw=scanner.next();
			login(usernamee,passw);
			break;
		default:
			break;
		}
	}
	private static void login(String username,String password) throws showError {
		try(Connection connection=JDBCConnection.getUser()){
			PreparedStatement ps=connection.prepareStatement(
					"select * from users where username=?");
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false) {
				throw new showError("Username does not exist");
			}
			else {
				PreparedStatement pst=connection.prepareStatement(
						"select * from users where username=?");
				pst.setString(1,username);
				ResultSet rst=pst.executeQuery();
				if(rst.getString(password)==password) {
					System.out.println("successful");
				}
				else {
					System.out.println("password doesnt match");
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	private static void signin(String userna,String passwo) throws showError {
		try(Connection connection=JDBCConnection.getUser()){
			PreparedStatement ps=connection.prepareStatement(
					"select * from users where username=?");
			ps.setString(1,userna);
			ResultSet rs=ps.executeQuery();
			if(rs.next()!=false) {
				throw new showError("Username Already exists");
			}
			else {
				PreparedStatement pst=connection.prepareStatement(
						"insert into users(username,password) values(?,?)");
				pst.setString(1,userna);
				pst.setString(2,passwo);
				pst.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
