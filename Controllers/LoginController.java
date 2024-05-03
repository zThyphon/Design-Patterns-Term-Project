package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Database.Database;
import Views.AuthenticatedUserView;

public class LoginController {
    //Operates login operation
    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Email");
        String email = scanner.nextLine();

        System.out.println("Enter Password");
        String password = scanner.nextLine();

        Boolean isAuthenticated = passwordCheck(email, password);
        if(isAuthenticated)
        {
            new AuthenticatedUserView(email);
            AuthenticatedUserController.showSelectionScreen(email);
        }   
        else
        {
            System.out.println("Password does not match!");
        }
        scanner.close();
    }

    /*Checks user entered password and actual user password and 
    returns true/false accordingly match of passwords*/
    
    public static boolean passwordCheck(String email, String enteredPassword)
    {
        Connection connection = Database.getConnection();
        Boolean isAuthenticated = false;
        String query = "SELECT password FROM users WHERE email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query))
        {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) 
            {
                String userPassword = rs.getString("password");
                // Compare the passwords
                if (enteredPassword.equals(userPassword)) 
                {
                    isAuthenticated = true;
                    System.out.println("User authenticated");
                } else 
                {
                    isAuthenticated = false;
                }
            } 
            else 
            {
                System.out.println("User not found!");
                isAuthenticated = false;
            }
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }

        return isAuthenticated;
    }
}
