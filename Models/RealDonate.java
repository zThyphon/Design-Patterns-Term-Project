package Models;
import Database.DatabaseContext;
import Database.CreateCommand;
import DateTime.DateTime;

/*Real donate class (part of the proxy design pattern)
this class is real subject of the proxy design pattern*/
public class RealDonate implements Donate{

    //Makes donate transaction to the database
    public void donate(String charity, String donatorEmail, double amount){
        DatabaseContext dbContext;
        String donation = "$" + Double.toString(amount);
        dbContext = new DatabaseContext(new CreateCommand());
        String donationDate = DateTime.getDate();
        donatorEmail = donatorEmail.replace("'", "''");
        charity = charity.replace("'", "''");
        donation = donation.replace("'", "''");
        donationDate = donationDate.replace("'", "''");
        
        String createDonationQuery = "INSERT INTO donations(donatorEmail, charity, amount, dateTime) VALUES('" +
        donatorEmail + "','" + charity + "','" + donation + "','" + donationDate + "')";
        
        dbContext.executeStrategy(createDonationQuery);
    }
}
