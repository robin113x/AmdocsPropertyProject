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
			property nppty = new property(id,name,price,area);
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

		property uppty = new property(id,name,price,area);
		PropertyDAO.updateppty (uppty); 
	}

	public static void display() { //display whole details
		PropertyDAO.displayppt ();
	}

	public static void searchbyid() throws validation { //search by using id
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter property id ");
		int id= sc.nextInt();   
		property sppty = new property(id);
		PropertyDAO.searchppty(sppty);
	}
	public static void searchbyprice() { //search by using price
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the maximum amount that can be spend on the property");
		Integer price= sc.nextInt();   


		PropertyDAO.searchpptybyprice(price);
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		boolean exit = false;

		while(!exit) {
			System.out.println(1+" "+"Insert");
			System.out.println(2+" "+"Delete");
			System.out.println(3+" "+"Update");
			System.out.println(4+" "+"Display");
			System.out.println(5+" "+"Search by ID");
			System.out.println(6+" "+"Search by price");
			System.out.println(7+" "+"Exit");
			System.out.println("Enter a valid choice ");
			int a= sc.nextInt();

			switch(a) {
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
				exit = true;
				break;

			default :
				System.out.println("Invalid choice.Please enter vaild choices!!");
			}

		}

	}
}
