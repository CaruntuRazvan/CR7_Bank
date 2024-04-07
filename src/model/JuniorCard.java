package model;

import model.enums.CardType;

public class JuniorCard extends Card {
    private double spendingLimit;

    public JuniorCard(CardType type) {
        super(type);
        this.spendingLimit = 0.0;
    }

    public void setSpendingLimit(double limit) {
        this.spendingLimit = limit;
    }

    public double getSpendingLimit() {
        return this.spendingLimit;
    }
    public void makeTransactionWithLimit(double amount) {
        if (amount > this.spendingLimit) {
            System.out.println("Limita de cheltuieli a fost depasita!");
        } else {
            super.withdraw(amount);
        }
    }

}
