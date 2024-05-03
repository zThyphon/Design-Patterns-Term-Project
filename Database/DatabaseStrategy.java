package Database;

/*Strategy execute command interface each strategy implements this 
database strategy*/

public interface DatabaseStrategy {
    void executeCommand(String query);
}
