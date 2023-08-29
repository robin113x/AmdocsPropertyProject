package Base;

import java.sql.SQLException;
import java.util.Scanner;


public class starter {

		private static Scanner scanner=new Scanner(System.in);
		static PropertyDAO dao=new PropertyDAO();
	public static void main(String[] args) throws SQLException, showError {
		
		register r=new register();
		register.suca();
		System.out.println("ucdba");
		
		int choice;
		
		while(true) {
			System.out.println("1: add property");
			System.out.println("2: Show all properties");
			System.out.println("3: Update property");
			System.out.println("4: delete property");
			System.out.println("5: Show advance search filters");
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
					advanceFilters();
					break;
				default:
					break;
			}
		}
	}
	private static void advanceFilters() throws SQLException, showError {
			int choice;
			System.out.println("11: Search particular property by id");
			System.out.println("12: Show properties only for sale");
			System.out.println("13: Search By price range");
			System.out.println("14: Search By Building");
			System.out.println("Any other to exit");                                  
			System.out.println("\t\t\t\t\t\tEnter your choice:");
			choice=scanner.nextInt();
			switch(choice) {
			case 11:
				searchProperty();
				break;
			case 12:
				dao.onlysellable();
				break;
			case 13:
				rangeSearch();
				break;
			case 14:
				byBuilding();
				break;
			default:
				break;
			}
	}
	private static void byBuilding() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Please enter building");
		String building=scanner.next();
		dao.searchBuilding(building);
	}
	private static void rangeSearch() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Lower Range");
		int lower=scanner.nextInt();
		System.out.println("Enter Upper Range");
		int upper=scanner.nextInt();
		dao.showInRange(lower,upper);
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
		System.out.println("Please enter price");
		int price=scanner.nextInt();
		System.out.println("Please enter building");
		String building=scanner.next();
		System.out.println("Please enter tower");
		String tower=scanner.next();
		System.out.println("Please enter status if for sale(1-sale/0-no sale)");
		boolean status=scanner.nextBoolean();
		Property prop=new Property(id,floor,price,building,tower,status);
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
		System.out.println("Please enter price");
		int price=scanner.nextInt();
		System.out.println("Please enter building");
		String building=scanner.next();
		System.out.println("Please enter tower");
		String tower=scanner.next();
		System.out.println("Please enter status if for sale");
		boolean status=scanner.nextBoolean();
		Property prop=new Property(id,floor,price,building,tower,status);
		dao.insert(prop);
	}

}