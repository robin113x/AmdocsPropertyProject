package property;

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
	
	public void addData(Connection con, Scanner sc, BufferedReader br) {
		
		try {
			System.out.print("Enter Property Name : ");
			String pname = br.readLine();
			daoObj.setPropName(pname);
			
			System.out.println("\nEnter Property Area : ");
			String area = br.readLine();
			daoObj.setPropArea(area);
			
			System.out.print("\nEnter Property Price : ");
			Float price = sc.nextFloat();
			daoObj.setPropPrice(price);
			
			System.out.print("\nEnter Property Owner : ");
			String owner = br.readLine();
			daoObj.setPropOwner(owner);
			
			System.out.print("\nEnter Property Buyer : ");
			String buyer = br.readLine();
			daoObj.setPropBuyer(buyer);
		
		} catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			String sql = "INSERT INTO property (Property_ID, Property_Name, Property_Area, Property_Price, Property_Owner, Property_Buyer) VALUES(?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, daoObj.getPropID());
			statement.setString(2, daoObj.getPropName());
			statement.setString(3, daoObj.getPropArea());
			statement.setFloat(4, daoObj.getPropPrice());
			statement.setString(5, daoObj.getPropOwner());
			statement.setString(6, daoObj.getPropBuyer());
			
			statement.executeUpdate();
			
			System.out.println(daoObj.getPropName());
			System.out.println("Record created : ");
			
			//To display the inserted values
			
			String pname =  daoObj.getPropName().toString();
			
			DisplayProperty dispObj = new DisplayProperty();
			
			dispObj.displayPro(con,pname);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
