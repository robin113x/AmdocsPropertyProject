package com.amdocs.in;


import java.sql.Connection;
import java.util.Scanner;
import com.amdoc.DAO.UserDAO;
import com.amdoc.DAO.User;

public class App {
    public  boolean loginReg(Connection conn) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();

                    User newUser = new User();
                    newUser.setUsername(regUsername);
                    newUser.setPassword(regPassword);

                    if (UserDAO.register(newUser,conn)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    if (UserDAO.login( conn,loginUsername, loginPassword)) {
                        System.out.println("Login successful!");
                        return true;
                        
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                        return false;
                    }
//                    break;

                case 3:
                    System.out.println("Exiting...");
                   
                    scanner.close();
                    System.exit(0);
                    
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
