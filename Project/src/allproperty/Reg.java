package allproperty;

import java.util.Scanner;

public class Reg {
	public static void register() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name= sc.next();
		System.out.println("Enter Email id");
		String eid= sc.next();
		System.out.println("Enter password");
		String pswd= sc.next();
		user_ rppty = new user_(name,eid,pswd);
		PropertyDAO.registration(rppty);
	}



	public static void login() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email ID");
		String eid= sc.next();
		System.out.println("Enter Password");
		String password= sc.next();
		user_ rppty = new user_(eid,password);
		PropertyDAO.login(rppty);//check login 
	}



	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Welcome to Property Management System ");
		System.out.println(1+" "+"Register");
		System.out.println(2+" "+"Login");
		System.out.println("Enter a choice:");
		int a= sc.nextInt();

		switch(a) {
		case 1:
			register();
			break;
		case 2:
			login();
			break;
		}	

	}

}
