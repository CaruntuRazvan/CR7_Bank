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
        /*
        System.out.println("Carduri asociate:");
        for (Card card : user.getCards()) {
            System.out.println("- Tip: " + card.getType());
        }
        */
        Card standardCard = new Card(CardType.STANDARD);
        PremiumCard premiumCard = new PremiumCard(CardType.PREMIUM);

        user.addCard(standardCard);
        user.addCard(premiumCard);

        System.out.println("Carduri asociate:");
        for (Card card : user.getCards()) {
            System.out.println("- " + card.getType());
        }

        int chosenCardIndex = 0; // presupunem că utilizatorul a ales primul card din listă
        Card chosenCard = user.interactWithCard(chosenCardIndex);
        System.out.println("Ai ales să interacționezi cu cardul: " + chosenCard.getType());
        // Afișarea informațiilor despre cardul ales
        System.out.println(chosenCard.getCardInfo());
        //Informatii dupa ce am adaugat si retras sume de bani
        chosenCard.deposit(100);
        chosenCard.withdraw(20);
        System.out.println(chosenCard.getCardInfo());
        //afisare istoric tranzactii
        chosenCard.displayTransactions();

        //transferam bani la cardul premium
        chosenCard.transferMoney(premiumCard, 50);
        System.out.println(chosenCard.getCardInfo());
        int chosenCardIndex2 = 1; // presupunem că utilizatorul a ales primul card din listă

        PremiumCard chosenCard2 = (PremiumCard) user.interactWithCard(chosenCardIndex2);
        System.out.println(chosenCard2.getCardInfo());

        chosenCard2.addToSavings(4);
        System.out.println(chosenCard2.getSavingsBalance());
        /*
        System.out.println("Balanța RON : " + chosenCard2.getBalance() + " RON");
        System.out.println("Balanța EUR : " + chosenCard2.getBalanceInEUR() + " EUR");

        premiumCard.transferRONtoEUR(20);
        System.out.println("Balanța RON dupa convertire: " + chosenCard2.getBalance() + " RON");
        System.out.println("Balanța EUR dupa convertire: " + chosenCard2.getBalanceInEUR() + " EUR");
        */

    }
}
