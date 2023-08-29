package com.amdocs.in;

import com.amdoc.DAO.*;

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
		Connection connRes = GetConnection.getConnection(conn);
		while(true) {
		ConsoleApp userApp = new ConsoleApp();
		boolean userFound=userApp.loginReg(connRes);
		if(userFound)break;
		}
		
		
		int opt;
		try {
			while (true) {

				System.out.println("1.Add Property");
				System.out.println("2.Update Property : ");
				System.out.println("3.View all Property ");
				System.out.println("4.Delete Property ");
				System.out.println("5.Search Property ");
				System.out.println("6.Avilable Property ");
				System.out.println("7.Price Range ");
				System.out.println("8.Exit ");
				System.out.print("Enter your option : ");
				opt = sc.nextInt();
				sc.nextLine();
				if (opt == 8) {
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
					upObj.updatePropperty(connRes, sc, br);
					break;
				case 3:
					ViewProperty viewObj = new ViewProperty();
					viewObj.viewProperty(connRes);
					break;
				case 4:
					DeleteProp deleObj = new DeleteProp();
					deleObj.deleteProp(connRes, sc);
					break;
				case 5:
					System.out.print("Choose Your Area : ");
					String area = br.readLine();
					Search sObj = new Search();
					sObj.searchPro(connRes, area);
					break;
				case 6:
					AvilableProp aviObj = new AvilableProp();
					aviObj.avilablePro(connRes);
				case 7:
					SearchPrice seaObj = new SearchPrice();
					System.err.print("Enter Minium Price : ");
					int minP = sc.nextInt();
					System.err.print("Enter Maxium Price : ");
					int maxP = sc.nextInt();
					seaObj.searchPri(connRes, minP, maxP);
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
