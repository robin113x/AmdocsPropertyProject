package allproperty;


import java.util.*;

public class Main {
	public static void insert() {//insert the data
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Property id");
			int id= sc.nextInt();
			System.out.println("Enter Property name");
			String name= sc.next();
			System.out.println("Enter Price");
			int price = sc.nextInt();
			System.out.println("Enter Area");
			String area = sc.next();
			System.out.println("Validity: yes or no");
			String valid = sc.next();
			property nppty = new property(id,name,price,area,valid);
			PropertyDAO.insertppty (nppty); 
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}
	

	
	public static void delete() {//delete the data
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter property id");
		int id= sc.nextInt();
		property dppty = new property(id);//calling constructor
		PropertyDAO.deleteppty(dppty);
	}
	
	
	
	public static void update() {//update the already available property data
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter property id");
		int id= sc.nextInt();   //check if id is there
		System.out.println("Enter property name");
		String name= sc.next();
		System.out.println("Enter Price");
		int price = sc.nextInt();
		System.out.println("Enter area");
		String area = sc.next();
		System.out.println("Validity: Yes or No");
		String valid = sc.next();

		property uppty = new property(id,name,price,area,valid);
		PropertyDAO.updateppty (uppty); 
	}
	
	

	public static void display() { //display whole details
		PropertyDAO.displayppt ();
	}
	
	

	public static void searchbyid() throws validation{ //search by using id
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter property id ");
		int id= sc.nextInt();   
		property sppty = new property(id);
		PropertyDAO.searchppty(sppty);
	}
	
	
	
	public static void searchbyprice() { //search by using price
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the maximum amount that can be spend on the property");
		Integer maxprice= sc.nextInt(); 
		System.out.println("Enter the minimum amount that can be spend on the property");
		Integer minprice= sc.nextInt(); 

		PropertyDAO.searchpptybyprice(maxprice,minprice);
	}
	
	

	public static void searchvalid() { //display whole details
		PropertyDAO.searchbyvalidity ();
	}
	
	

	public static void searchbyarea() {//delete the data
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter property area");
		String area= sc.next();
		property dppty = new property(area);//calling constructor
		
		PropertyDAO.searcharea(dppty);
	}
	

	
	public static void menu() throws validation{
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			System.out.println(1+" "+"Insert");
			System.out.println(2+" "+"Delete");
			System.out.println(3+" "+"Update");
			System.out.println(4+" "+"Display");
			System.out.println(5+" "+"Search by ID");
			System.out.println(6+" "+"Search by price");
			System.out.println(7+" "+"Search by validity");
			System.out.println(8+" "+"Search by Area");
			System.out.println(9+" "+"Exit");
			System.out.println("Enter a valid choice ");
			int b= sc.nextInt();

			switch(b) {
			case 1:
				Main.insert();
				break;
			case 2:
				Main.delete();
				break;
			case 3:
				Main.update();
				break;
			case 4:
				Main.display();
				break;
			case 5:
				Main.searchbyid();
				break;
			case 6:
				Main.searchbyprice();
				break;	
			case 7:
				Main.searchvalid();
				break;		
			case 8:
				Main.searchbyarea();
				break;		
			case 9:
				exit = true;
				break;

			default :
				System.out.println("Invalid choice.Please enter vaild choices!!");
			}

		}

	}

}
