package base;
import java.util.Scanner;
import java.sql.*;
import java.util.List;
public class Main {

	public static void main(String[] args) throws SQLException, errorException  {

		try (
				Connection connection= DatabaseConnection.getConnection())
		{

			Scanner scanner = new Scanner(System.in);
			int choice =0;
			do {
				System.out.println("1.Register: ");
				System.out.println("2.LogIn: ");
				System.out.println("3.Exit: ");
				System.out.print("\n*************************");
				System.out.println("\nEnter the choice: ");
				choice = scanner.nextInt();
				scanner.nextLine();

				switch(choice) {
				case 1:
					// registering the new user 
					System.out.print("Enter the Username: ");
					String username = scanner.next();
					System.out.print("Enter the password: ");
					String password = scanner.next();

					PropertyDAO propertyDAO = new PropertyDAO(connection);
					boolean registerSucess= propertyDAO.registerUser(username,password);
					if(registerSucess) {
						System.out.println("Register Sucessfully: ");
						
					}else 
					{
						System.out.println("Register UnSucessfull: ");
					}
					break;
				case 2:
					// login the new user
					System.out.print("Enter the Username: ");
					String loginUsername = scanner.next();
					System.out.print("Enter the password: ");
					String loginPassword = scanner.next();

					boolean logedIn = logInUser(connection,loginUsername,loginPassword);
					if(logedIn) {
						System.out.print("Logged in Sucessfully ! ");
						System.out.print("\n*************************");
						System.out.print("\n");
						loginMenu(connection);
						
					}
					else {
						System.out.print("Logged in unSucessfull ! Retry Please ! ");
					}
					break;
				case 3:
					System.out.println("Exiting ...! ");
					System.exit(0);
					break;

				default :
					System.out.println("Invalid Choice! ... Choose from 1-3! ");
				}
			}while (choice !=3);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

// check if the user is registered or not in database 
	private static boolean logInUser(Connection connection, String loginUsername, String loginPassword) throws SQLException {
		PropertyDAO propertyDAO = new PropertyDAO(connection);
		return propertyDAO.logInUser(loginUsername,loginPassword);
	}

	// login menu call if the login is successfully done 
	public static void loginMenu(Connection connection) throws SQLException, errorException {

		PropertyDAO propertyDAO = new PropertyDAO(connection);
		Scanner scanner = new Scanner(System.in);
		int choice ;
		do {
			System.out.println("1. Add Property:");
			System.out.println("2. Update Property:");
			System.out.println("3. Delete Property:");
			System.out.println("4. Dispaly Property:");
			System.out.println("5. Search Property:");
			System.out.println("6. Filter By price");
			System.out.println("7. Exit");
			System.out.print("*************************");
			System.out.println("\nEnter your choice:");

			choice = scanner.nextInt();
			//	
			//				scanner.nextInt(); 

			switch(choice) {
			case 1:
				System.out.print("Enter the property Id: ");
				int propId=scanner.nextInt();

				System.out.print("Enter the property Location: ");
				String propLocation=scanner.next();

				System.out.print("Enter the property Name: ");
				String propName=scanner.next();

				System.out.print("Enter the price: ");
				float propPrice=scanner.nextFloat();

				System.out.print("Enter the type: ");
				String propType=scanner.next();

				System.out.print("Enter the status: ");
				String propStatus = scanner.next();

				Property newProperty = new Property(propId,propName,propLocation,propPrice,propType,propStatus);
				propertyDAO.addProperty(newProperty);
				System.out.println("Property added sucessfully. ");
				System.out.print("*************************");
				break; 

			case 2: 
				System.out.print("Enter property ID to update: ");
				int propIdToUpdate = scanner.nextInt();
				scanner.nextLine();

				List<Property> properties = propertyDAO.getAllProperties();
				Property propertyToUpdate = null;
				for (Property property : properties) {
					if (property.getProp_id() == propIdToUpdate) {
						propertyToUpdate = property;
						break;
					}
				}
				if (propertyToUpdate == null) {
					System.out.println("property not found. ");
				}
				else {
					System.out.print("Enter new property location: ");
					String newPropLocation = scanner.next();

					System.out.print("Enter new property price: ");
					float newPropPrice = scanner.nextFloat();

					scanner.nextLine(); // Consume the newline

					System.out.print("Enter new property name: ");
					String newPropName = scanner.next();

					System.out.print("Enter new property Type: ");
					String newPropType = scanner.next();

					propertyToUpdate.setProp_location(newPropLocation);
					propertyToUpdate.setProp_price(newPropPrice);
					propertyToUpdate.setProp_name(newPropName);
					propertyToUpdate.setProp_name(newPropType);

					propertyDAO.updateProperty(propertyToUpdate);
					System.out.println("Property updated successfully.");
				}
				break;

			case 3:
				System.out.print("Enter property ID to delete: ");
				int propIdToDelete = scanner.nextInt();
				scanner.nextLine();

				propertyDAO.deleteProperty(propIdToDelete);
				System.out.println("property deleted sucessfully. ");
				break;

			case 4:
				List<Property> propertiesToDisplay = propertyDAO.getAllProperties();
				System.out.println("Properties:");
				for ( Property property: propertiesToDisplay) {
					System.out.println(property);
				}
				break;
			case 5:
				System.out.print("Enter the PropertyId: ");
				int prop_Id=scanner.nextInt();
				String status ="sold";
				Property searchR =propertyDAO.propertySearchByIdAndStatus(prop_Id,status);

				if(searchR == null) {
					throw new errorException ("No such type of Property is available");

				}					
				else{	
					System.out.println("Property Found !");
					System.out.println(searchR);
				}
				break;

			case 6:
				System.out.println("Enter the Min_price:");
				int min_price =scanner.nextInt();
				System.out.println("Enter the Max_price:");
				int max_price = scanner.nextInt();

				List <Property> priceR= propertyDAO.propertySearchByPrice(min_price,max_price);

				if(priceR.isEmpty()) {
					throw new errorException("No such range of property is available");
				}else 
				{
					System.out.println("Here's the Property !");
					for(Property property: priceR) {
						System.out.println(property);
					}
				}
				break;

			case 7:
				System.out.println("Thank u for Choosing us!");
				System.exit(0);
				break;
			default: 
				System.out.println("Invalid input !");
			}

		} while (choice != 6);
		
	}
}





