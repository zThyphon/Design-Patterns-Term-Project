package Views;
import Controllers.AuthenticatedUserController;

public class AuthenticatedUserView 
{
    public AuthenticatedUserView(String userEmail){
        System.out.println("-Authenticated User Screen-");
        AuthenticatedUserController.showSelectionScreen(userEmail);
    }
}
