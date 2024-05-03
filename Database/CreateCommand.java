package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

//Create operation of database operations (with strategy design pattern)
public class CreateCommand implements DatabaseStrategy {
    static Connection connection = Database.getConnection();
    @Override
    public void executeCommand(String query) {
        if (connection != null)
        {
            try 
            {
                PreparedStatement statement = connection.prepareStatement(query);
    
                statement.executeUpdate();
            } 
            catch (SQLException e) 
            {
                System.err.println("SQL Exception: " + e.getMessage());
            }
        }
    }
}
