public class ApplicationMain {
    public static void main(String[] args) {
        // Creăm un utilizator pentru testare
        User user = new User("john_doe", "password123");

        // Simulăm procesul de autentificare
        String enteredUsername = "john_doe";
        String enteredPassword = "password123";
        if (user.authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Autentificare reușită! Bun venit, " + user.getUsername() + "!");
        } else {
            System.out.println("Autentificare eșuată. Nume de utilizator sau parolă incorectă.");
        }
    }
}
