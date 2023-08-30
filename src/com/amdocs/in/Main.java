package com.amdocs.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Scanner;

import com.amdoc.DAO.ToSell;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		System.out.println("Hello, Welcome to Property Management System.");
		
		Connection conn = null;
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection con = GetConnection.getConnection(conn);
		
		while(true) {
			App userApp = new App();
			boolean userFound=userApp.loginReg(con);
			if(userFound)break;
			}
		
		
		
		int log=1;
		
		int opt;
		
		if(log==1) 			
		{	
			try 
			{			
				while (true) 			
				{				
					Connection connRes = GetConnection.getConnection(conn);				
			
					System.out.println("1.Add Property");				
					System.out.println("2.Update Property : ");				
					System.out.println("3.View all Property ");				
					System.out.println("4.Delete Property ");				
					System.out.println("5.Search Property ");				
					System.out.println("6. Search Property By Price Range ");	
					System.out.println("7. Check Whether the property is on sell or not : ");
					System.out.println("8.Exit ");				
					System.out.print("Enter your option : ");
				
					opt = sc.nextInt();
				    sc.nextLine();				
				
				    if (opt == 8)				
				    {			    	
				    	System.out.println("Thank You");
					   	break;
				    }
				
				    System.out.println();
				    
				    switch (opt) 
				    {
				    
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
				    	String area = br.readLine().toLowerCase().trim();
				    	Search sObj = new Search();
				    	sObj.searchPro(connRes, area);
				    	break;
				    	
				    case 6:
				    	System.out.println("Choose the price range : ");
				    	System.out.println("Enter the starting price");
				    	int st = sc.nextInt();
				    	System.out.println("Enter the ending range : ");
				    	int ed = sc.nextInt();
				    	SearchPrice spObj = new SearchPrice();
				    	spObj.searchPri(connRes , st, ed);
				    	break;
				    	
				    case 7:
				    	System.out.println("Check");
				    	ToSell seObj = new ToSell();
				    	seObj.avilablePro(connRes);
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
	else
	{
		System.out.println("Credential does not match");
	
	}
	}
}
