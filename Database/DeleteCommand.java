package Database;

//Delete operation of database operations (with strategy design pattern)
public class DeleteCommand implements DatabaseStrategy {
    public void executeCommand(String query) {
        System.out.println("Executing Delete Command");
        
    }
}
