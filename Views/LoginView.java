package Views;
import Controllers.LoginController;

public class LoginView
{
    public LoginView()
    {
        System.out.println("-Login Screen-");
        LoginController.login();
    }

}