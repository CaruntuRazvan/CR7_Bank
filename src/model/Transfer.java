package model;

import java.time.LocalDateTime;

public class Transfer {
    private Card sourceCard;
    private Card destinationCard;
    private double amount;
    private LocalDateTime timestamp;


    public Transfer(Card sourceCard, Card destinationCard, double amount) {
        this.sourceCard = sourceCard;
        this.destinationCard = destinationCard;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters și Setters pentru toate câmpurile

    public Card getSourceCard() {
        return sourceCard;
    }

    public void setSourceCard(Card sourceCard) {
        this.sourceCard = sourceCard;
    }

    public Card getDestinationCard() {
        return destinationCard;
    }

    public void setDestinationCard(Card destinationCard) {
        this.destinationCard = destinationCard;
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