package com.atm.entity;

import java.util.*;

public class Client extends Person{


    private List<Account> account = new ArrayList<>();
    private Card card;

    public Client() {
    }

    public Client(long id, String name, String surname, String gender, String race, String address, List<Account> account, Card card) {
        super(id, name, surname, gender, race, address);
        this.account = account;
        this.card = card;
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
            }
        }
        return acc;
    }

}
