import Database.DatabaseContext;
import Database.CreateTableCommand;
import Views.AuthenticationSelectionView;

public class Main {
    public static void main(String[] args) {
        /*Calls the function which creates database tables
        with using strategy design pattern*/
        createDatabaseTables();
        //Shows user selection screen
        new AuthenticationSelectionView();
    }

    //Creates database tables if not exists
    public static void createDatabaseTables(){
        DatabaseContext dbContext;
        dbContext = new DatabaseContext(new CreateTableCommand());

        String createUserTableQuery = "CREATE TABLE IF NOT EXISTS users(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "username TEXT NOT NULL," +
        "email TEXT NOT NULL UNIQUE,"+
        "password TEXT NOT NULL)";

        String createCharityTableQuery = "CREATE TABLE IF NOT EXISTS charity(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name TEXT NOT NULL UNIQUE,"+
        "creatorEmail TEXT NOT NULL," +
        "creationDate TEXT NOT NULL)";

        String createDonationsTableQuery = "CREATE TABLE IF NOT EXISTS donations(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "donatorEmail TEXT NOT NULL," +
        "charity TEXT NOT NULL,"+
        "amount  TEXT NOT NULL,"+
        "dateTime TEXT NOT NULL)";

        dbContext.executeStrategy(createUserTableQuery);
        dbContext.executeStrategy(createCharityTableQuery);
        dbContext.executeStrategy(createDonationsTableQuery);
    }
}