package Database;

//Database context (part of the strategy design pattern)
public class DatabaseContext {
    public DatabaseStrategy strategy;

    public DatabaseContext(DatabaseStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(DatabaseStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void executeStrategy(String query){
        strategy.executeCommand(query);
    }
}
