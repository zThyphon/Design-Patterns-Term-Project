package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.Database;
import Views.AuthenticatedUserView;

public class UserDonationsController {
    //Get user's donates to other charities
    public static void getUserDonates(String userEmail) {
        Connection connection = Database.getConnection();
        String query = "SELECT charity, amount ,dateTime FROM donations WHERE donatorEmail=?";
    
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, userEmail);
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) 
            {
                String charityName = rs.getString("charity");
                String amount = rs.getString("amount");
                String donationDateTime = rs.getString("dateTime");
                System.out.println("Charity: "+charityName+ ", Amount: " + amount + ", Donation Date: " + donationDateTime);
            }
    
            new AuthenticatedUserView(userEmail);
            AuthenticatedUserController.showSelectionScreen(userEmail);
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
