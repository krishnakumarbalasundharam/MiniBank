package MiniBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/BankAccount";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Admin";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace(); // For debugging
            return null;
        }
    }
}
