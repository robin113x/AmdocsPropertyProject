package property_management_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello, Welcome to Property Management System.");
		Connection conn = null;
		//System.out.println(GetConnection.getConnection(conn));
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opt;
		try {
			while (true) {
				Connection connRes = GetConnection.getConnection(conn);
				System.out.println("1.Add Property");
				System.out.println("2.Update Property : ");
				System.out.println("3.View all Property ");
				System.out.println("4.Delete Property ");
				System.out.println("5.Search Property ");
				System.out.println("6.Search by Price Range ");
				System.out.println("7.Exit ");
				System.out.print("Enter your option : ");
				opt = sc.nextInt();
				sc.nextLine();
				if (opt == 7) {
					System.out.println("Thank You");
					break;
				}
				System.out.println();
				switch (opt) {
				case 1:
					AddProperty addObj = new AddProperty();
					addObj.addData(connRes, sc, br);
					break;
				case 2:
					UpdateProperty upObj = new UpdateProperty();
					upObj.updatePropperty(connRes, sc,br);
					break;
				case 3:
					System.out.println("View");
					ViewProperty viewObj = new ViewProperty();
					viewObj.viewProperty(connRes);
					break;
				case 4:
					DeleteProperty deleObj = new DeleteProperty();
					deleObj.deleteProp(connRes,sc);
					break;
				case 5:
					System.out.print("Choose Your Area : ");
					String area = br.readLine();
					Search sObj = new Search();
					sObj.searchPro(connRes, area);
					break;
				case 6:
					System.out.println("Enter first price:- ");
					int first = sc.nextInt();
					System.out.println("Enter second price:- ");
					int second = sc.nextInt();
					SearchPriceRange srchobj = new SearchPriceRange();
					srchobj.searchPrice(connRes, first, second);
					break;
				default:
					System.out.println("Choose Vaild Options . ");
					break;
				}
			}
		} finally {
			sc.close();
		}
	}
}