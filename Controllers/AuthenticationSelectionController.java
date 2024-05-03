package Controllers;

import java.util.Scanner;

import Views.LoginView;
import Views.RegisterView;

public class AuthenticationSelectionController {
    //Show operation list to user
    public static void authenticationSelectionScreen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Operation");
        System.out.println("1)Login");
        System.out.println("2)Register");
        System.out.println("3)Close the Application");
        System.out.print("Select Operation: ");
        try
        {
            int operation = scanner.nextInt();
            selectOperation(operation);
        }
        catch(Exception e)
        {
            System.out.println("Invalid operation");
            authenticationSelectionScreen();
        }

        scanner.close();
    }

    //Redirects corresponding view according to user selection
    public static void selectOperation(int operation)
    {
        System.out.println("Operation: "+operation);
        if(operation == 1)
        {
            new LoginView();
        }

        else if(operation == 2)
        {
            new RegisterView();
        }
        else if(operation==3)
        {
            System.out.println("Application has been closed");
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid operation");
            authenticationSelectionScreen();
        }
    }
}
