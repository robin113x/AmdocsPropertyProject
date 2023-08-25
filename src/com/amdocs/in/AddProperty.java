package com.amdocs.in;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.amdoc.POJO.*;

public class AddProperty {
	POJO pojoObj;
	Scanner sc;
	PreparedStatement statement;

	public AddProperty() {
		pojoObj = new POJO();
	}

	public void addData(Connection conn,Scanner sc,BufferedReader br) {
		try {
			System.out.print("\nEnter the Name of property : ");
			String pname = br.readLine();
			pojoObj.setPname(pname);
			System.out.print("\nEnter the Area of Property : ");
			String area = br.readLine();
			System.out.println();
			pojoObj.setArea(area);
			System.out.print("\nEnter the Price of property : ");
			Float price = sc.nextFloat();
			pojoObj.setPrice(price);
			System.out.print("\nEnter Owner Name : ");
			String owner = br.readLine();
			pojoObj.setoName(owner);
			System.out.print("\nEnter Buyer Name : ");
			String buyer = br.readLine();
			pojoObj.setbName(buyer);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			String sql = "INSERT INTO PropInfo (Pid, PName, PArea,Price,OwnerName,BuyerName) VALUES (?,?,?,?, ?, ?)";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, pojoObj.getPid());
			statement.setString(2, pojoObj.getPname());
			statement.setString(3, pojoObj.getArea());
			statement.setFloat(4, pojoObj.getPrice());
			statement.setString(5, pojoObj.getoName());
			statement.setString(6, pojoObj.getbName());
			statement.executeUpdate();
			System.out.println(pojoObj.getPname());
			System.out.println("Record created : ");
			//Display Values
			
			String pname =  pojoObj.getPname().toString();
			DisplayProperty dispObj = new DisplayProperty();
			dispObj.displayPro(conn,pname);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
