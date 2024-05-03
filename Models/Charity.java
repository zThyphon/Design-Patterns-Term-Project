package Models;
import Database.CreateCommand;
import Database.DatabaseContext;

//Charity Model (with builder design pattern)
public class Charity {
    private String name;
    private String creatorEmail;
    private String creationDate;

    public Charity() {}

    public Charity(Builder builder)
    {
        this.name = builder.name;
        this.creationDate = builder.creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatorEmail(){
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail){
        this.creatorEmail = creatorEmail;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    

    public static class Builder{
        private String name;
        private String creatorEmail;
        private String creationDate;

        public Builder(){}

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder creatorEmail(String creatorEmail){
            this.creatorEmail = creatorEmail;
            return this;
        }

        public Builder creationDate(String creationDate)
        {
            this.creationDate = creationDate;
            return this;
        }

        public Charity build()
        {
            DatabaseContext dbContext;
            dbContext = new DatabaseContext(new CreateCommand());
            name = name.replace("'", "''");
            creatorEmail = creatorEmail.replace("'", "''");
            creationDate = creationDate.replace("'", "''");


            String createUserQuery = "INSERT INTO charity(name, creatorEmail, creationDate) VALUES('"+
            name + "','" + creatorEmail + "','" + creationDate + "')";
            
            dbContext.executeStrategy(createUserQuery);
            return new Charity(this);
        }
        
    }
}
