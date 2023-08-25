package com.amdoc.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class DisplayProperty {
	Statement statement;

	public void displayPro(Connection conn, String pname) {
		try {
			statement = conn.createStatement();
			String QUERY = "SELECT * FROM PropInfo where PName='"+pname+"';";
			ResultSet rs = statement.executeQuery(QUERY);
			System.out.println("***************************************");
			while (rs.next()) {
				// Display values
				System.out.println("PID : " + rs.getInt("Pid"));
				System.out.println("Name : " + rs.getString("PName"));
				System.out.println("Area : " + rs.getString("PArea"));
				System.out.println("Price : " + rs.getFloat("Price"));
				System.out.println("Owner : " + rs.getString("OwnerName"));
				System.out.println("Buyer : " + rs.getString("BuyerName"));
			}
			System.out.println("\n***************************************\n");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}