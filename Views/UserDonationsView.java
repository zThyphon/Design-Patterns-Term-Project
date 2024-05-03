package Views;

import Controllers.UserDonationsController;

public class UserDonationsView {
    public String userEmail;
    
    public UserDonationsView(String userEmail)
    {
        System.out.println("-My Last Donations-");
        UserDonationsController.getUserDonates(userEmail);
    }
}
