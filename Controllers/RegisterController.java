package Controllers;

import java.util.Scanner;

import Models.Charity;
import Models.User;
import Views.LoginView;

public class RegisterController {
    //Operates register operation (with builder design pattern)
    public static void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username");
        String username = scanner.nextLine();

        System.out.println("Enter Email");
        String email = scanner.nextLine();

        System.out.println("Enter Password");
        String password = scanner.nextLine();

        System.out.println("Confirm Password");
        String confirmPassword = scanner.nextLine();

        System.out.println("Charity Name");
        String charityName = scanner.nextLine();

        System.out.println("Charity Creation Date (DD-MM-YYYY format)");
        String charityCreationDate = scanner.nextLine();

        if((username.isEmpty()) || (email.isEmpty()) || 
        (password.isEmpty()) || (confirmPassword.isEmpty()) ||
        (charityName.isEmpty()) || (charityCreationDate.isEmpty())){
            System.out.println("Please Enter All Values");
            register();
        } 
        else
        {
            if(!password.equals(confirmPassword))
            {
                System.out.println("Passwords are not Matched");
                register();
            }
            else
            {
                try
                {
                    new User.Builder()
                    .username(username)
                    .email(email)
                    .password(password)
                    .build();

                    new Charity.Builder()
                    .name(charityName)
                    .creatorEmail(email)
                    .creationDate(charityCreationDate)
                    .build();
                    
                    new LoginView();
                }
                catch(Exception e)
                {
                    System.out.println("User could not been created. Check your inputs.");
                }
            }
        }
        scanner.close();
    }
}
