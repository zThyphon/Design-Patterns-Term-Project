package Models;
import Database.CreateCommand;
import Database.DatabaseContext;

//User Model (with builder design pattern)
public class User {
    private String username;
    private String email;
    private String password;

    public User() {
        System.out.println("Default constructor");
    }

    public User(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Builder class
    public static class Builder {
        private String username;
        private String email;
        private String password;

        public Builder(){}
        
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

      
        public User build() {
            DatabaseContext dbContext;
            dbContext = new DatabaseContext(new CreateCommand());
            username = username.replace("'", "''");
            email = email.replace("'", "''");
            password = password.replace("'", "''");


            String createUserQuery = "INSERT INTO users(username, email, password) VALUES('"+
            username + "','" + email + "','" + password + "')";
            
            dbContext.executeStrategy(createUserQuery);
            return new User(this);
        }
    }
}
