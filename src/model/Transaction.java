package model;

import model.enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction {
    private double amount;
    private TransactionType type;
    private LocalDateTime timestamp;

    public Transaction(TransactionType type, double amount) {
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }
    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
