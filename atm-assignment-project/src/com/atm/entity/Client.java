package com.atm.entity;

import java.util.*;

public class Client {

    private String firstName;
    private String lastName;
    private long clientID;
    private List<Account> account = new ArrayList<>();
    private Card card;

    public Client() {
    }

    public Client(String firstName, String lastName, long clientID, List<Account> account, Card card) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientID = clientID;
        this.account = account;
        this.card = card;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    //given a list of account numbers and an account number search and return if found
    public Account getAnAccount(long accNumber){

        Account acc = null;
        for (Account accnts: account) {
            if(accnts.getAccountNumber()==accNumber){
                acc =accnts;
            }else{
                System.out.println("ACCOUNT NOT ON CLIENT lIST");
            }
        }
        return acc;
    }



    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", clientID=" + clientID +
                ", account=" + account +
                ", card=" + card +
                '}';
    }
}
