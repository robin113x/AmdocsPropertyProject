package com.amdoc.DAO;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProperty {
	public void updatePropperty(Connection conn, Scanner sc,BufferedReader br) {
		try {
			System.out.print("Enter the ID of the property to update: ");
			int propertyIdToUpdate = sc.nextInt();
			sc.nextLine();

			while (true) {
				String updateQuery;
				PreparedStatement preparedStatement;
				float newPrice = 0;
				int rowsAffected = 0;
				String newOwnerName = "null";
				String newBuyerName = "null";
				System.out.println("1.Price");
				System.out.println("2.Owner");
				System.out.println("3.Buyer");
				System.out.println("4.All");
				System.out.println("5.Exit");
				System.out.print("choose Option : ");
				int opt = sc.nextInt();
				if (opt >= 5) {
					break;
				}
				switch (opt) {
				case 1:
					updateQuery = "UPDATE PropInfo SET  Price = ?WHERE Pid = ?";
					System.out.print("Enter new Property Price: ");
					newPrice = sc.nextFloat();
					sc.nextLine();
					preparedStatement = conn.prepareStatement(updateQuery);
					preparedStatement.setFloat(1, newPrice);
					preparedStatement.setInt(2, propertyIdToUpdate);
					rowsAffected = preparedStatement.executeUpdate();
					System.out.println(rowsAffected + " row(s) updated.");
					

					break;
				case 2:
					updateQuery = "UPDATE PropInfo SET  OwnerName = ?WHERE Pid = ?";
					System.out.print("Enter new Property Owner Name: ");
					newOwnerName = br.readLine();
					preparedStatement = conn.prepareStatement(updateQuery);
					preparedStatement.setString(1, newOwnerName);
					preparedStatement.setInt(2, propertyIdToUpdate);
					rowsAffected = preparedStatement.executeUpdate();
					System.out.println(rowsAffected + " row(s) updated.");
					break;
				case 3:
					updateQuery = "UPDATE PropInfo SET  BuyerName = ?WHERE Pid = ?";
					System.out.print("Enter new Property Buyer Name: ");
					newBuyerName = br.readLine();
					preparedStatement = conn.prepareStatement(updateQuery);
					preparedStatement.setString(1, newBuyerName);
					preparedStatement.setInt(2, propertyIdToUpdate);
					rowsAffected = preparedStatement.executeUpdate();
					System.out.println(rowsAffected + " row(s) updated.");
					break;
				case 4:
					updateQuery = "UPDATE PropInfo SET  Price = ?, OwnerName = ?, BuyerName = ? WHERE Pid = ?";
					System.out.print("Enter new Property Price: ");
					newPrice = sc.nextFloat();
					sc.nextLine();
					System.out.print("Enter new Property Owner Name: ");
					newOwnerName = br.readLine();
					System.out.print("Enter new Property Buyer Name: ");
					newBuyerName = br.readLine();

					preparedStatement = conn.prepareStatement(updateQuery);
					preparedStatement.setFloat(1, newPrice);
					preparedStatement.setString(2, newOwnerName);
					preparedStatement.setString(3, newBuyerName);
					preparedStatement.setInt(4, propertyIdToUpdate);
					rowsAffected = preparedStatement.executeUpdate();
					System.out.println(rowsAffected + " row(s) updated.");
					break;

				default:
					System.out.println("Thanks");
					break;
				}
					System.out.println("Do you want to Update More [y/n] : ");
					String ans = sc.next().toLowerCase();
					if(ans.equals("n") || ans!="y") {
						break;
					}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
