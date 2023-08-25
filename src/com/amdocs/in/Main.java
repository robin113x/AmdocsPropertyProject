package com.amdocs.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello, Welcome to Property Management System.");
		Connection conn = null;
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opt;
		try {
			while (true) {
				Connection connRes = GetConnection.getConnection(conn);
				System.out.println("Press 1 to Add Property");
				System.out.println("Press 2 to Update Property : ");
				System.out.println("Press 3 to View All Property");
				System.out.println("Press 4 to Delete a Property ");
				System.out.println("Press 5 to Search any Property");
				System.out.println("Press 6 to Exit ");
				System.out.print("Enter your option : ");
				opt = sc.nextInt();
				sc.nextLine();
				if (opt == 6) {
					System.out.println("Thank You");
					break;
				}
				System.out.println();
				switch (opt) {
				case 1:
					AddProperty addObj = new AddProperty();
					addObj.addData(connRes,sc,br);
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
					DeleteProp deleObj = new DeleteProp();
					deleObj.deleteProp(connRes,sc);
					break;
				case 5:
					System.out.print("Choose Your Area : ");
					String area = br.readLine();
					Search sObj = new Search();
					sObj.searchPro(connRes, area);
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
