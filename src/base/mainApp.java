package base;

import java.util.*;

public class mainApp {

	private static List<propertyEnt> propList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DBA_Connector.getConnection());

		int option;

		System.out.println("\n*** MENU ***");

		do {
			System.out.println("1. Enter the details of property");
			System.out.println("2. Update porperty");
			System.out.println("3. To view proprty details");
			System.out.println("4. Delete property");
			System.out.println("5. Search property");
			System.out.println("6. Exit\n");

			option = sc.nextInt();

			switch (option) {
			case 1:
				addProp();
				break;

			case 2:
				updateProp();
				break;

			case 3:
				viewProp();
				break;

			case 4:
				delProp();
				break;

			case 5:
				searchProp();
				break;

			case 6:
				System.out.println("Exit");
				break;

			default:
				System.out.println("Please enter the valid choice 1 to 6");
				break;
			}

		} while (option != 6);

		sc.close();

	}

	// adding property details
	private static void addProp() {
		// adding property details
		System.out.println("Enter the property id: ");
		int propId = sc.nextInt();
		System.out.println("Enter the property name: ");
		String propName = sc.next();
		System.out.println("Enter the area of the: ");
		String areaName = sc.next();
		System.out.println("Enter the cost of the area: ");
		int propPrice = sc.nextInt();
		System.out.println("Enter the owner name: ");
		String ownerName = sc.next();
		System.out.println("Enter the buyer name: ");
		String buyerName = sc.next();

		propertyEnt obj = new propertyEnt(propId, propName, areaName, propPrice, ownerName, buyerName);
		propList.add(obj);
		System.out.println("________________________________________");
		System.out.println("\nadded successfully\n");

		DOA daoObj = new DOA();
		daoObj.insert(obj);
	}
	
	// updating property
	private static void updateProp() {
		// updating property
		propertyEnt obj2 = new propertyEnt(0, null, null, 0, null, null);
		System.out.println("Updating the details, please enter ID");
		obj2.setPropId(sc.nextInt());
		System.out.println("Enter property name you want to update");
		obj2.setPropName(sc.next());
		System.out.println("Enter the area name you want to update");
		obj2.setArea(sc.next());
		System.out.println("Enter the property price you want to update");
		obj2.setCost(sc.nextInt());
		System.out.println("Enter the property owner name you want to update");
		obj2.setOwnerName(sc.next());
		System.out.println("Enter the property buyer name you want to update");
		obj2.setBuyerName(sc.next());

		DOA doaObj = new DOA();
		doaObj.update(obj2);
		System.out.println("_______________________________________");
		System.out.println("Updation completed");

	}

	//view property
	private static void viewProp() {
		DOA daoObj = new DOA();
		List<propertyEnt> propList = daoObj.getAllDetails();

		for (propertyEnt obj : propList) {
			System.out.println("Property Id :" + obj.getPropId());
			System.out.println("Property Name :" + obj.getPropName());
			System.out.println("Property Area :" + obj.getArea());
			System.out.println("Property Cost :" + obj.getCost());
			System.out.println("Property Owner :" + obj.getOwnerName());
			System.out.println("Property Buyer :" + obj.getBuyerName());
			System.out.println("________________________________________");
		}
	}

	//delete property
	private static void delProp() {
		DOA doaobj = new DOA();
		System.out.println("Enter the id for entry you want to delete");
		doaobj.deletProp(sc.nextInt());
		System.out.println("data deleted");
		System.out.println("________________________________________");
	}

	//searching property
	private static void searchProp() {
		DOA doaObj = new DOA();
		System.out.println("Enter the id  of property you want to search");

		try {
			doaObj.searchDetails(sc.nextInt());
		} catch (PropertyNotFoundException e) {
			System.out.println(e);
		}
		System.out.println("________________________________________");
		System.out.println("\ndata searched\n");

	}

}
