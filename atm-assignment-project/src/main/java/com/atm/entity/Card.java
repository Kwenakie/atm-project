package com.atm.entity;

public class Card {
    private long cardNumber;
    private int cardPin;
    private Account account;

    public Card() {
    }

    public Card(long cardNumber, int cardPin, Account account) {
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
        this.account = account;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardPin() {
        return cardPin;
    }

    public void setCardPin(int cardPin) {
        this.cardPin = cardPin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", cardPin=" + cardPin +
                ", account=" + account +
                '}';
    }
}
