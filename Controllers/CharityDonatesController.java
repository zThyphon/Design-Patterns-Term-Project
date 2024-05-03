package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.Database;
import Views.AuthenticatedUserView;

public class CharityDonatesController {
    //Gets donates list whose are donated to corresponding charity
    public static void getCharityDonates(String charityName, String userEmail) {
        Connection connection = Database.getConnection();
        String query = "SELECT amount, dateTime FROM donations WHERE charity=?";
    
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, charityName);
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) 
            {
                String amount = rs.getString("amount");
                String donationDateTime = rs.getString("dateTime");
                System.out.println("Amount: " + amount + ", Donation Date: " + donationDateTime);
            }
    
            new AuthenticatedUserView(userEmail);
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
