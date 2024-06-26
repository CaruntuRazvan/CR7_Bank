package model;

import model.enums.CardType;
import model.enums.TransactionType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Card {
    private CardType type;
    private String cardNumber;
    private String expirationDate;
    private String CVV;
    private boolean isBlocked;
    protected String currency;
    protected double balance;

    private List<Transaction> transactions;
    private List<Transfer> transfers;
    public Card(CardType type) {
        this.type = type;
        this.cardNumber = generateCardNumber();
        LocalDate expirationDate = LocalDate.now().plusYears(5); // 5 ani distanță de momentul actual
        this.expirationDate = expirationDate.format(DateTimeFormatter.ofPattern("MM/yy")); // formatare caracteristica
        this.CVV = generateCVV();
        this.isBlocked = false;
        this.balance = 0.0;
        this.currency = "RON";
        this.transactions = new ArrayList<>();
        this.transfers = new ArrayList<>();

    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public CardType getType() {
        return type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCVV() {
        return CVV;
    }
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (isBlocked) {
            System.out.println("Cardul este blocat !");
            return;
        }
        if (amount >= 5.0) {
            this.balance += amount;
            Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount);
            transactions.add(transaction);
        } else {
            System.out.println("Suma minimă de depunere este de 5 RON.");
        }
    }
    public void withdraw(double amount) {
        if (isBlocked) {
            System.out.println("Cardul este blocat !");
            return;
        }
        if (amount <= this.balance) {
            this.balance -= amount;
            Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount);
            transactions.add(transaction);
        } else {
            System.out.println("Fonduri insuficiente!");
        }
    }
    private String generateCardNumber() {
        StringBuilder cardNumberBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) { // un număr de card are 16 cifre
            int digit = random.nextInt(10); // generăm o cifră aleatorie între 0 și 9
            cardNumberBuilder.append(digit);
            if ((i + 1) % 4 == 0 && i != 15) { // adăugăm spații după fiecare grup de 4 cifre
                cardNumberBuilder.append(" ");
            }
        }
        return cardNumberBuilder.toString();
    }
    private String generateCVV() {
        Random random = new Random();
        int cvv = random.nextInt(900) + 100; // generăm un număr între 100 și 999
        return String.valueOf(cvv); // convertim numărul la șir de caractere și returnăm
    }

    public void transferMoney(Card destinationCard, double amount) {
        if (isBlocked) {
            System.out.println("Cardul este blocat !");
            return;
        }
        if (amount >= 5 && amount <= this.balance) { // Verificăm dacă suma este pozitivă și există suficient sold pe card
            this.balance -= amount; // Reducem soldul cardului sursă
            destinationCard.deposit(amount); // Depunem suma pe cardul destinație
            System.out.println("Transferul de " + amount + " RON a fost efectuat cu succes către cardul " + destinationCard.getCardNumber());
        } else {
            System.out.println("Transferul de bani nu a putut fi efectuat. Verificați suma introdusă și/sau soldul disponibil pe card.");
        }
    }
    public void performTransfer(Card destinationCard, double amount) {
        Transfer transfer = new Transfer(this, destinationCard, amount);
        this.transferMoney(destinationCard, amount);
        this.addTransfer(transfer);
        destinationCard.addTransfer(transfer);
    }

    public void displayCardInfo() {
        String currencySymbol;
        if ("RON".equals(this.currency)) {
            currencySymbol = "RON";
        } else if ("EURO".equals(this.currency)) {
            currencySymbol = "EURO";
        } else {
            currencySymbol = ""; // poți adăuga alte valute în viitor
        }

        System.out.println("Informații despre card:");
        System.out.println("Numar: " + this.cardNumber);
        System.out.println("Expirare: " + this.expirationDate);
        System.out.println("CVV: " + this.CVV);
        System.out.println("Balanta: " + this.balance + " " + currencySymbol);
        System.out.println();
    }

    public void displayTransactions() {
        //afiseaza de la cel mai actual la cel mai vechi
        transactions.sort(Comparator.comparing(Transaction::getTimestamp).reversed());
        System.out.println("Istoric tranzactii:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Transaction transaction : transactions) {
            String formattedDateTime = transaction.getTimestamp().format(formatter);
            System.out.println("Tip: " + transaction.getType());
            System.out.println("Suma: " + transaction.getAmount());
            System.out.println("Data: " + formattedDateTime);
            System.out.println(); // pt claritate
        }
    }

    public void addTransfer(Transfer transfer) {
        transfers.add(transfer);
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }
    public void displayTransfers() {
        transfers.sort(Comparator.comparing(Transfer::getTimestamp).reversed());
        System.out.println("Istoric transferuri:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Transfer transfer : transfers) {
            String formattedDateTime = transfer.getTimestamp().format(formatter);
            System.out.println("De la cardul " + transfer.getSourceCard().getType() + " cu numarul " + transfer.getSourceCard().getCardNumber() + " la cardul " + transfer.getDestinationCard().getType() + " cu numarul " + transfer.getDestinationCard().getCardNumber());
            System.out.println("Suma: " + transfer.getAmount());
            System.out.println("Data: " + formattedDateTime);
            System.out.println(); // pt claritate
        }
    }

    public void blockCard() {
        isBlocked = true;
    }

    public void unblockCard() {
        isBlocked = false;
    }
}
