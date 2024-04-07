package model;

import model.enums.CardType;

public class PremiumCard extends Card {
    private double savings;
    private double balanceInEUR;

    // Constructor
    public PremiumCard(CardType type) {
        super(type); // Apelăm constructorul clasei de bază
        this.savings = 0.0;
        this.balanceInEUR = 0.0;
    }

    public double getSavings() {
        return savings;
    }

    public void addToSavings(double amount) {
        this.savings += amount;
        this.balance -= amount;
    }

    public void displaySavingsBalance() {
        System.out.println("Informații despre economii:");
        System.out.println("Economii: " + this.savings + " RON\n");
    }

    public void addToBalanceInEUR(double amountInEUR) {
        balanceInEUR += amountInEUR;
    }
    public void addToBalance(double amountInRon){
        balance += amountInRon;
    }


    // Metodă pentru a obține balanța euro
    public double getBalanceInEUR() {
        return balanceInEUR;
    }

    public void setBalanceInEUR(double balanceInEUR) {
        this.balanceInEUR = balanceInEUR;
    }

    public double convertRONToEUR(double amountInRON) {

        double exchangeRate = 4.9;
        // Adăugăm o taxă de conversie de 1%
        double conversionFee = 0.01;
        return (amountInRON / exchangeRate) * (1 - conversionFee);
    }
    public double convertEURToRon(double amountInEUR) {

        double exchangeRate = 4.9;
        // Adăugăm o taxă de conversie de 1%
        double conversionFee = 0.01;
        return amountInEUR * exchangeRate * (1 - conversionFee);
    }

    public void transferRONtoEUR(double amountInRON) {
        if (amountInRON > getBalance()) {
            System.out.println("Eroare: Balanța RON este insuficientă.");
            return;
        }
        double amountInEUR = convertRONToEUR(amountInRON);
        addToBalanceInEUR(amountInEUR);
        setBalance(getBalance() - amountInRON);
    }
    public void transferEURtoRON(double amountInEUR) {
        if (amountInEUR > getBalanceInEUR()) {
            System.out.println("Eroare: Balanța EUR este insuficientă.");
            return;
        }
        double amountInRON = convertEURToRon(amountInEUR);
        addToBalance(amountInRON);
        setBalanceInEUR(getBalanceInEUR() - amountInEUR);
    }

    public void displayBalanceInRON() {
        String formattedBalanceInRON = String.format("%.2f", this.getBalance());
        System.out.println("Balanta RON : " + formattedBalanceInRON + " RON\n");
    }

    public void displayBalanceInEUR() {
        String formattedBalanceInEUR = String.format("%.2f", this.getBalanceInEUR());
        System.out.println("Balanta EUR : " + formattedBalanceInEUR + " EUR\n");
    }


}
