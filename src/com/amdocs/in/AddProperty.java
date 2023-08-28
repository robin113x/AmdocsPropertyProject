package com.amdocs.in;

import java.io.BufferedReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.amdoc.DAO.*;

//here we make a class of add property
public class AddProperty {
	//here we define the object(daoObj) of class DAO
	DAO daoObj;
	//Scanner sc;
	
	//here we use the object(statement) of predefined class PreparedStatement
	PreparedStatement statement;

	//here we make constructor of AddProperty()
	public AddProperty() {
		//here we make the object of DAO
		daoObj = new DAO();
	}

	// here we do method call with connection conn,sc and br why are we taking object br and sc
	//as we have to make one time object of br and sc optimizing the space
	public void addData(Connection conn, Scanner sc, BufferedReader br)
	{
		try {
			
			System.out.print("\nEnter Property Name : ");
			String pname = br.readLine();
			daoObj.setPname(pname);
			
			System.out.print("Enter Property Area : ");
			String area = br.readLine();
			System.out.println();
			daoObj.setArea(area);
			
			System.out.print("\nEnter Property Price : ");
			Float price = sc.nextFloat();
			daoObj.setPrice(price);
			
			System.out.print("\nEnter Property Owner : ");
			String owner = br.readLine();
			daoObj.setoName(owner);
			
			System.out.print("\nEnter Property Buyer : ");
			String buyer = br.readLine();
			daoObj.setbName(buyer);

		} 
		
		catch (Exception e) 
		{
			System.out.println(e);
		}

		try {
			
			String sql = "INSERT INTO PropInfo (Pid, PName, PArea,Price,OwnerName,BuyerName) VALUES (?,?,?,?, ?, ?)";
			
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, daoObj.getPid());
			statement.setString(2, daoObj.getPname());
			statement.setString(3, daoObj.getArea());
			statement.setFloat(4, daoObj.getPrice());
			statement.setString(5, daoObj.getoName());
			statement.setString(6, daoObj.getbName());
			
			statement.executeUpdate();
			
			//System.out.println(daoObj.getPname());
		
			
			// Display Values
			String pname = daoObj.getPname().toString();
			DisplayProperty dispObj = new DisplayProperty();
			
			dispObj.displayPro(conn, pname);
			System.out.println("Record created : ");
			

		} 
		
		catch (SQLException e)
		{
			//this gives the line in which exception is coming
			e.printStackTrace();
			//sysout print all the exception which is coming and e.printStackTrace gives exact line
			//System.out.println(e);
		}

	}
}
