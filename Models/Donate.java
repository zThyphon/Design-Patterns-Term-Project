package Models;

//Donate interface (a part of proxy design pattern)
public interface Donate{
    void donate(String charity, String donatorEmail, double amount);
}