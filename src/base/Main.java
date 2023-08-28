package base;
import java.util.Scanner;
import java.sql.*;
import java.util.List;
public class Main {

	public static void main(String[] args) throws errorException {
	
			

		try (
				Connection connection= DatabaseConnection.getConnection())
		{
			PropertyDAO propertyDAO = new PropertyDAO(connection);

			Scanner scanner = new Scanner(System.in);
			int choice =0;

			do {
				System.out.println("1. Add Property:");
				System.out.println("2. Update Property:");
				System.out.println("3. Delete Property:");
				System.out.println("4. Dispaly Property:");
				System.out.println("5. Search Property:");
				System.out.println("6. Exit");
				System.out.println("Enter your choice:");

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

					Property newProperty = new Property(propId,propName,propLocation,propPrice,propType);
					propertyDAO.addProperty(newProperty);
					System.out.println("Property added sucessfully. ");
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

					Property searchR =propertyDAO.propertySearchById(prop_Id);
	
					if(searchR == null) {
						throw new errorException ("No such type of Property is available");
						
					}					
					else{	
						System.out.println("Property Found !");
						System.out.println(searchR);
					}
					break;
				case 6:
					System.out.println("Thank u for Choosing us!");
					System.exit(0);
					break;
				default: 
					System.out.println("Invalid input !");
				}

			} while (choice != 6);
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
