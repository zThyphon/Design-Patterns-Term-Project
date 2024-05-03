package Views;
import Controllers.CharitiesController;
import Controllers.AuthenticatedUserController;
public class CharitiesView {
    public String userEmail;

    public CharitiesView(String userEmail)
    {
        this.userEmail = userEmail;
        System.out.println("-Charity List-");
        showCharities();
    }
    
    public void showCharities(){
        CharitiesController.getCharityList();
        new AuthenticatedUserView(userEmail);
        AuthenticatedUserController.showSelectionScreen(userEmail);
    }

}
