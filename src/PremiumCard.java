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

    public String getSavingsBalance() {
        String savingsBalance = "Informații despre savings:\n";
        savingsBalance += "Savings: " + this.savings + " RON\n";
        return savingsBalance;
    }
    public void addToBalanceInEUR(double amountInEUR) {
        balanceInEUR += amountInEUR;
    }

    // Metodă pentru a obține balanța euro
    public double getBalanceInEUR() {
        return balanceInEUR;
    }
    public double convertToEUR(double amountInRON) {

        double exchangeRate = 4.9;
        // Adăugăm o taxă de conversie de 1%
        double conversionFee = 0.01;
        return (amountInRON / exchangeRate) * (1 - conversionFee);
    }
    public double convertFromEUR(double amountInEUR) {

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
        double amountInEUR = convertToEUR(amountInRON);
        addToBalanceInEUR(amountInEUR);
        setBalance(getBalance() - amountInRON);
    }

}
