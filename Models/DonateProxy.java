package Models;

/*Donate proxy (part of the proxy design pattern) proxy class
of the proxy design pattern */

public class DonateProxy implements Donate {
    private RealDonate realDonate;
    private String securityKey;
    private static String securityAuthenticationKey = "123456";

    public DonateProxy(String securityKey)
    {
        this.securityKey = securityKey;
    }

    public void initializePayment()
    {
        if(realDonate == null){
            realDonate = new RealDonate();
        }
    }

    public void donate(String charity, String donatorEmail, double amount)
    {
        boolean isSecure = securityCheck();
        if(isSecure){
            initializePayment();
            realDonate.donate(charity,donatorEmail,amount);
        }
        else
        {
            System.out.println("Unsecure authentication detected!");
        }
    }

    private boolean securityCheck(){
        return securityKey.equals(securityAuthenticationKey);
    }
}
