package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Database.Database;
import Views.AuthenticationSelectionView;
import Views.CharitiesView;
import Views.CharityDonatesView;
import Views.DonationView;
import Views.UserDonationsView;

public class AuthenticatedUserController {
    //Shows selection screen to authenticated users
     public static void showSelectionScreen(String userEmail)
     {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1)View Charity List");
        System.out.println("2)Donate to Other Charities");
        System.out.println("3)View Donates to My Charity");
        System.out.println("4)View My Last Donations");
        System.out.println("5)Logout");
        System.out.println("Select Operation");
        int operation = scanner.nextInt();

        try
        {
            if(operation == 1)
            {
                CharitiesView charitiesScreen = new CharitiesView(userEmail);
                charitiesScreen.showCharities();
            }
            else if(operation == 2)
            {
                new DonationView();
                DonationController.getDonationCredentials(userEmail);   
            }
            else if(operation == 3)
            {
                new CharityDonatesView(userEmail);
                String charityName = getCharityName(userEmail);
                CharityDonatesController.getCharityDonates(charityName,userEmail);
            }
            else if(operation == 4)
            {
                new UserDonationsView(userEmail);
            }
            else if(operation ==5)
            {
                System.out.println("Logged out");
                new AuthenticationSelectionView();
            }
            else
            {
                System.out.println("Invalid operation.");
                showSelectionScreen(userEmail);
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid operation.");
            showSelectionScreen(userEmail);
        }

        scanner.close();
    }

    //Gets user's charity name for showing donates to his/her charity
    public static String getCharityName(String creatorEmail)
    {
        Connection connection = Database.getConnection();
        String query = "SELECT name FROM charity where creatorEmail=?";


        try (PreparedStatement pstmt = connection.prepareStatement(query))
        {
            pstmt.setString(1, creatorEmail);
            ResultSet rs = pstmt.executeQuery();

            String charityName = rs.getString("name");
            return charityName;
        }
        catch (SQLException e) 
        {
            return e.getMessage();
        }
    }
}
