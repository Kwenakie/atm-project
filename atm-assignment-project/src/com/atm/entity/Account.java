package com.atm.entity;

public class Account {
 private long accountNumber;
 private double avaliableBalance;
 private String history;

    public Account() {
    }

    public Account(long accountNumber, double avaliableBalance, String history) {
        this.accountNumber = accountNumber;
        this.avaliableBalance = avaliableBalance;
        this.history = history;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAvaliableBalance() {
        return avaliableBalance;
    }

    public void setAvaliableBalance(double avaliableBalance) {
        this.avaliableBalance = avaliableBalance;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", avaliableBalance=" + avaliableBalance +
                ", history='" + history + '\'' +
                '}';
    }
}
