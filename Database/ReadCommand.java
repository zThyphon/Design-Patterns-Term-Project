package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Read operation of database operations (with strategy design pattern)
public class ReadCommand implements DatabaseStrategy {
    static Connection connection = Database.getConnection();
    public void executeCommand(String query) {
        try (PreparedStatement pstmt = connection.prepareStatement(query))
        {
            ResultSet rs = pstmt.executeQuery();
            System.out.println(rs);
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
    }
}
