package com.amdocs.in;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getConnection(Connection conn) {
		String dbURL = "jdbc:mysql://localhost:3306/ProjectDB";
		String username = "root";
		String password = "ksmr24@1";
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				System.out.println("******************");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return conn;
	}
}
