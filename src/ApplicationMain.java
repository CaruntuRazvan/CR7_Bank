import model.Card;
import model.enums.CardType;
import model.PremiumCard;
import model.User;

//TODO - ??impartire in clase service si apoi apelarea lor in main
//TODO - Idei pentru noi clase??


public class ApplicationMain {
    public static void main(String[] args) {
        // Creăm un utilizator pentru testare
        User user = new User("madalin_ciocan", "ciocanesku");

        // Simulăm procesul de autentificare
        String enteredUsername = "madalin_ciocan";
        String enteredPassword = "ciocanesku";
        if (user.authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Autentificare reușită! Bun venit, " + user.getUsername() + "!");
        } else {
            System.out.println("Autentificare eșuată. Nume de utilizator sau parolă incorectă.");
        }

        Card standardCard = new Card(CardType.STANDARD);
        PremiumCard premiumCard = new PremiumCard(CardType.PREMIUM);

        user.addCard(standardCard);
        user.addCard(premiumCard);
        user.displayCards();

        int chosenCardIndex = 0; // presupunem că utilizatorul a ales primul card din listă
        Card chosenCard = user.interactWithCard(chosenCardIndex);
        System.out.println("Ai ales să interacționezi cu cardul: " + chosenCard.getType());
        chosenCard.displayCardInfo();
        //Informatii dupa ce am adaugat si retras sume de bani
        chosenCard.deposit(100.0);
        chosenCard.withdraw(20.0);
        chosenCard.displayCardInfo();
        //afisare istoric tranzactii
        chosenCard.displayTransactions();

        //transferam bani la cardul premium
        chosenCard.performTransfer(premiumCard, 50.0);
        chosenCard.displayTransfers();
        chosenCard.displayCardInfo();

        int chosenCardIndex2 = 1; // presupunem că utilizatorul a ales al doilea card din listă
        PremiumCard chosenCard2 = (PremiumCard) user.interactWithCard(chosenCardIndex2);
        System.out.println("Ai ales să interacționezi cu cardul: " + chosenCard2.getType());
        chosenCard2.displayCardInfo();
        chosenCard2.displayTransfers();
        chosenCard2.addToSavings(4.0);
        chosenCard2.displaySavingsBalance();
        chosenCard2.displayCardInfo();

        chosenCard2.transferRONtoEUR(20);
        chosenCard2.displayBalanceInRON();
        chosenCard2.displayBalanceInEUR();
        chosenCard2.transferEURtoRON(2);
        chosenCard2.displayBalanceInRON();
        chosenCard2.displayBalanceInEUR();
        /*
        //!!!PROBLEMA LA DEPOSIT, NU FACE ROTUNJIREA CORECT
        chosenCard2.enableRounding();
        chosenCard2.deposit(21.7);
        chosenCard2.displayBalanceInRON();
        chosenCard2.displaySavingsBalance();
        */


    }
}
