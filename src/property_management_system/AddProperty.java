package property_management_system;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import POJO.*;

public class AddProperty {
	POJO daoObj;
	Scanner sc;
	PreparedStatement statement;

	public AddProperty() {
		daoObj = new POJO();
	}

	public void addData(Connection conn, Scanner sc, BufferedReader br) {
		try {
			System.out.print("Enter Property Name : ");
			String pname = br.readLine();
			daoObj.setPname(pname);
			System.out.println("\nEnter Property Address : ");
			String area = br.readLine();
			// System.out.println();
			daoObj.setArea(area);
			System.out.print("\nEnter Property Owner : ");
			String owner = br.readLine();
			daoObj.setoName(owner);
			System.out.print("\nEnter Property Buyer : ");
			String buyer = br.readLine();
			daoObj.setbName(buyer);
			System.out.print("\nEnter Property Price : ");
			Float price = sc.nextFloat();
			daoObj.setPrice(price);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			String sqlQuery = "INSERT INTO property (Property_ID,Property_Name, Property_Address, Owner_Name, Buyer_Name , Property_Price) VALUES(?,?,?,?,?,?);";
			statement = conn.prepareStatement(sqlQuery);
			statement.setInt(1, daoObj.getPid());
			statement.setString(2, daoObj.getPname());
			statement.setString(3, daoObj.getArea());
			statement.setString(4, daoObj.getoName());
			statement.setString(5, daoObj.getbName());
			statement.setFloat(6, daoObj.getPrice());
			statement.executeUpdate();
			//System.out.println(daoObj.getPname());
			System.out.println("Record created : ");
			// Display Values

			String pname = daoObj.getPname().toString();
			DisplayProperty dispObj = new DisplayProperty();
			dispObj.displayPro(conn, pname);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
