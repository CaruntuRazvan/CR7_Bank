import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Card> cards;
    // Constructor
    public User(String username, String password) {
        this.username = username;
        if(isValidPassword(password)) {
            this.password = password;
        } else{
            throw new IllegalArgumentException("Parola trebuie să aiba minim 6 caractere!");
        }
        this.cards = new ArrayList<>();
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
    // Metoda pentru verificarea credențialelor de autentificare
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String getUsername() {
        return username;
    }
    public List<Card> getCards() {
        return cards;
    }
    public void addCard(Card card) {
        CardType type = card.getType();
        if (!hasCardOfType(type)) {
            cards.add(card);
        } else {
            System.out.println("Utilizatorul deja deține un card de tipul " + type + ".");
        }
    }

    private boolean hasCardOfType(CardType type) {
        for (Card card : cards) {
            if (card.getType() == type) {
                return true; // Utilizatorul deține deja un card de acest tip
            }
        }
        return false;
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public Card interactWithCard(int index) {
        return cards.get(index);

    }

}
