package Controllers;

import java.util.Scanner;

import Models.Donate;
import Models.DonateProxy;
import Views.AuthenticatedUserView;

public class DonationController {
    //Get donations from users
    public static void getDonationCredentials(String donatorEmail){
        try
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Charity");
            String charity = scanner.nextLine();

            System.out.println("Enter Amount (E.g: 100,3)");
            double amount = scanner.nextDouble();

            donate(charity, donatorEmail, amount);
            scanner.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            new AuthenticatedUserView(donatorEmail);
        }
    }

    //Operates donation (with proxy design pattern)
    public static void donate(String charity, String donatorEmail, double amount)
    {
        System.out.println(amount+"$ has been donated to "+charity+" successfully");

        Donate donation = new DonateProxy("123456");
        donation.donate(charity, donatorEmail, amount);

        new AuthenticatedUserView(donatorEmail);
    }
}
