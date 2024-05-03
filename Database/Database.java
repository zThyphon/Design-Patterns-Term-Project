package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Database connection with singleton design pattern
public class Database {
    private static Connection db;

    private Database() {}

    public static Connection getConnection() {
        if (db == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                db = DriverManager.getConnection("jdbc:sqlite:Database/database.db");
                System.out.println("\nConnected to database...");
            } 
            catch (ClassNotFoundException e) {
                System.err.println("Could not load JDBC driver: " + e.getMessage());
            } 
            catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
            }
        }
        return db;
    }
}
