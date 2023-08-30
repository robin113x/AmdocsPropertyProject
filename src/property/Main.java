package property;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to Property Management System");
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int key = 0;
		
		try {
			
			while (true) {
				
				Connection conRes = GetConnection.getConnection(con);
				System.out.println("1.Add Property");
				System.out.println("2.Update Property : ");
				System.out.println("3.View all Property ");
				System.out.println("4.Delete Property ");
				System.out.println("5.Search Property ");
				System.out.println("6.Search by Price Range ");
				System.out.println("7.Exit ");
				System.out.println("Enter your option : ");
				
				key = sc.nextInt();
				sc.nextLine();
				
				if (key == 7) {
					System.out.println("You have exited the sytem. \nThank You!");
					break;
				}
	
				switch (key) {
				case 1:
					AddProperty addObj = new AddProperty();
					addObj.addData(conRes, sc, br);
					break;
				
				case 2:
					UpdateProperty upObj = new UpdateProperty();
					upObj.updatePropperty(conRes, sc,br);
					break;
				
				case 3:
					System.out.println("View");
					ViewProperty viewObj = new ViewProperty();
					viewObj.viewProperty(conRes);
					break;
				
				case 4:
					DeleteProperty deleObj = new DeleteProperty();
					deleObj.deleteProp(conRes,sc);
					break;
				
				case 5:
					System.out.print("Choose Your Area : ");
					String area = br.readLine();
					Search sObj = new Search();
					sObj.searchPro(conRes, area);
					break;
				
				case 6:
					System.out.println("Enter first price:- ");
					int first = sc.nextInt();
					System.out.println("Enter second price:- ");
					int second = sc.nextInt();
					SearchPriceRange srchobj = new SearchPriceRange();
					srchobj.searchPrice(conRes, first, second);
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