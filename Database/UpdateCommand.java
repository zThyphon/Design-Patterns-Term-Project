package Database;

//Update operation of database operations (with strategy design pattern)
public class UpdateCommand implements DatabaseStrategy {
    public void executeCommand(String query) {
        System.out.println("Executing Update Command");
    }
}
