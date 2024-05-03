package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.Database;

public class CharitiesController {
    //Gets charity list from database
    public static void getCharityList(){
        Connection connection = Database.getConnection();
        String query = "SELECT name, creationDate FROM charity";

        try (PreparedStatement pstmt = connection.prepareStatement(query))
        {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String charityName = rs.getString("name");
                String creationDate = rs.getString("creationDate");
                System.out.println("Charity Name: " + charityName + ", Creation Date: " + creationDate);
            }
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
