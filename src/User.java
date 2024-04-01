public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Metoda pentru verificarea credențialelor de autentificare
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // Getter pentru numele utilizatorului
    public String getUsername() {
        return username;
    }
}
