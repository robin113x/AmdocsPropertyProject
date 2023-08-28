package Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class starter {

		private static Scanner scanner=new Scanner(System.in);
		static PropertyDAO dao=new PropertyDAO();
	public static void main(String[] args) throws SQLException, showError {
		System.out.println(JDBCConnection.getConnection());
		
		int choice;
		while(true) {
			System.out.println("1: add property");
			System.out.println("2: Show all properties");
			System.out.println("3: Update property");
			System.out.println("4: delete property");
			System.out.println("5: search property");
			System.out.println("Any other to exit");
			System.out.println("\t\t\t\t\t\tEnter your choice:");
			choice=scanner.nextInt();
			switch(choice) {
				case 1:
					addProperty();
					break;
				case 2:
					dao.showfull();
					break;
				case 3:
					updateProperty();
					break;
				case 4:
					removeProperty();
					break;
				case 5:
					searchProperty();
					break;
				default:
					break;
			}
		}
	}
	private static void searchProperty() throws SQLException, showError {
		System.out.println("Please enter id");
		int id=scanner.nextInt();
		dao.search(id);
	}
	private static void updateProperty() throws SQLException {
		System.out.println("Please enter id");
		int id=scanner.nextInt();
		System.out.println("Please enter floor");
		int floor=scanner.nextInt();
		System.out.println("Please enter PropertiesCol");
		String col=scanner.next();
		System.out.println("Please enter building");
		String building=scanner.next();
		System.out.println("Please enter tower");
		String tower=scanner.next();
		Property prop=new Property(id,floor,col,building,tower);
		dao.update(prop);
	}
	private static void removeProperty() throws SQLException {
		System.out.println("Please enter id");
		int id=scanner.nextInt();
		dao.remove(id);
		
	}
	private static void addProperty() throws SQLException {
		System.out.println("Please enter id");
		int id=scanner.nextInt();
		System.out.println("Please enter floor");
		int floor=scanner.nextInt();
		System.out.println("Please enter PropertiesCol");
		String col=scanner.next();
		System.out.println("Please enter building");
		String building=scanner.next();
		System.out.println("Please enter tower");
		String tower=scanner.next();
		Property prop=new Property(id,floor,col,building,tower);
		dao.insert(prop);
	}

}