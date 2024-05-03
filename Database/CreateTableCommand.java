package Database;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

//Create table operation of database operations (with strategy design pattern)
public class CreateTableCommand implements DatabaseStrategy {
    static Connection connection = Database.getConnection();

    @Override
    public void executeCommand(String query) {
        if (connection != null) 
        {
            try (Statement statement = connection.createStatement()) 
            {
                statement.execute(query);
            } 
            catch (SQLException e) 
            {
                System.err.println("Error executing SQL statement: " + e.getMessage());
            }
        }
    }
}
