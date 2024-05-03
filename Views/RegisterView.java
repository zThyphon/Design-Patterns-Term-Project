package Views;
import Controllers.RegisterController;

public class RegisterView {
    public RegisterView()
    {
        System.out.println("-Register Screen-");
        RegisterController.register();
    }
}
