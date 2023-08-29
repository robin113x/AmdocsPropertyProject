package com.amdoc.DAO;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.amdoc.POJO.*;

public class AddProperty {
	POJO daoObj;
	Scanner sc;
	PreparedStatement statement;

	public AddProperty() {
		daoObj = new POJO();
	}

	public void addData(Connection conn,Scanner sc,BufferedReader br) {
		try {
			System.out.print("\nEnter Property Name : ");
			String pname = br.readLine();
			daoObj.setPname(pname);
			System.out.print("Enter Property Area : ");
			String area = br.readLine();
			System.out.println();
			daoObj.setArea(area);
			System.out.print("Enter Property Price : ");
			Float price = sc.nextFloat();
			daoObj.setPrice(price);
			System.out.print("Enter Property Owner : ");
			String owner = br.readLine();
			daoObj.setoName(owner);
			System.out.print("Enter Property Buyer : ");
			String buyer = br.readLine();
			daoObj.setbName(buyer);
			System.out.print("Property Avilable[y/n] : ");
			String avi = br.readLine();
			daoObj.setAvi(avi);
			
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			String sql = "INSERT INTO PropInfo (Pid, PName, PArea,Price,OwnerName,BuyerName,Avilable) VALUES (?,?,?,?, ?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, daoObj.getPid());
			statement.setString(2, daoObj.getPname());
			statement.setString(3, daoObj.getArea());
			statement.setFloat(4, daoObj.getPrice());
			statement.setString(5, daoObj.getoName());
			statement.setString(6, daoObj.getbName());
			statement.setString(7, daoObj.getAvi());
			statement.executeUpdate();
			System.out.println("Record created : ");
			//Display Values
			
			String pname =  daoObj.getPname().toString();
			DisplayProperty dispObj = new DisplayProperty();
			dispObj.displayPro(conn,pname);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
