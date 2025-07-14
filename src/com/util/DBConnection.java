package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Important: Load driver class
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/batch1043", "root", "orchid@123"
            );
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }

}
