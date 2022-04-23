package com.atm.application;

import com.atm.entity.Account;
import com.atm.entity.Card;
import com.atm.entity.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AtmHelperApplication {

    private List<Account> accounts = new ArrayList<>();

    private List<Account> accounts1 = new ArrayList<>();

    private List<Account> accounts2 = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    private List<Card>cards = new ArrayList<>();



    public AtmHelperApplication() {
        Account ac = new Account(1234,2500.00,"NEW ACCOUNT");
        Account ac1 = new  Account(1235,500.00,"NEW ACCOUNT");
        Account ac2 = new  Account(1236,250.00,"NEW ACCOUNT");


        Account ac3 = new  Account(1237,25000.00,"NEW ACCOUNT");
        Account ac4 = new  Account(1238,2500.60,"NEW ACCOUNT");
        Account ac5 = new  Account(1239,250000.00,"NEW ACCOUNT");

        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);
        accounts.add(ac5);

        //client 2

        Account ac6 = new  Account(1137,25000.00,"NEW ACCOUNT");
        Account ac7 = new  Account(1138,2500.60,"NEW ACCOUNT");
        Account ac8 = new  Account(1139,250000.00,"NEW ACCOUNT");

        Account ac9 = new  Account(1337,25000.00,"NEW ACCOUNT");
        Account ac10 = new  Account(1338,2500.60,"NEW ACCOUNT");
        Account ac11= new  Account(1339,250000.00,"NEW ACCOUNT");

        accounts1.add(ac6);
        accounts1.add(ac7);
        accounts1.add(ac8);
        accounts1.add(ac9);
        accounts1.add(ac10);
        accounts1.add(ac11);

        //client 3

        Account ac12 = new  Account(1437,25000.00,"NEW ACCOUNT");
        Account ac13 = new  Account(1438,2500.60,"NEW ACCOUNT");
        Account ac14 = new  Account(1439,250000.00,"NEW ACCOUNT");

        accounts2.add(ac12);
        accounts2.add(ac13);
        accounts2.add(ac14);





        Card c1 = new Card(12367,1234,ac);
        Card c2 = new Card(12368,1235,ac6);
        Card c3 = new Card(12369,1236,ac12);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);

        Client cl1 = new Client("Kwena" , "Mbayeka" , 1212,accounts, c1);
        Client cl2 = new Client("Khumo" , "Mbayeka" , 1213,accounts1, c2);
        Client cl3 = new Client("Mntungwa" , "Nkosi" , 1214,accounts2, c3);



        clients.add(cl1);
        clients.add(cl2);
        clients.add(cl3);

    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clinets) {
        this.clients = clinets;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    //need reword
    public Client login(long cardNumber , int pin){


        Client theClient =null;

        for (Card card:cards) {
            if ( card.getCardNumber()==cardNumber){

                Client c = getClientGivenCardNumber(cardNumber);

                  if(c!=null ){

                      if(c.getCard().getCardPin() == pin){
                          theClient =c;
                      }else {
                          System.out.println("INCORRECT PIN ENTERED");
                      }
                  }
            }else {
                System.out.println("ENTERED CARD NUMBER DOES NOT EXIST");
            }
        }



        
        return theClient;
    }

    //get client given card number
    public Client getClientGivenCardNumber(long cardn){
        Client client= null;

        for (Client theclient:clients) {

            if(theclient.getCard().getCardNumber()==cardn){
                client =theclient;
            }else{
                System.out.println("THE GIVEN CARD NUMBER DOES NOT EXIST");
            }

        }

        return client;
    }


    //perform account Deposit
    public void performAccountDeposit(long cardn,int pin,long  accountNumber,double amount){

        Account acc = login(cardn,pin).getAnAccount(accountNumber) ;

        if(acc!=null){
        double balance = acc.getAvaliableBalance();
            acc.setAvaliableBalance(amount+balance);
            acc.setHistory("/n" + "ATM MONEY IN : R"+amount + " ON " + LocalDate.now());
            System.out.println("MONEY IN : R" +amount + " AND NEW AV B IS :R" + acc.getAvaliableBalance());
        }else {

            System.out.println("ACCOUNT DOESNT EXIST");
        }

    }

    //perform account Withdrawal
    public void performWithdrawal( long cardnum,int pin ,double amount){

        Client client = login(cardnum,pin);

        double avb= client.getCard().getAccount().getAvaliableBalance();

        if((amount <= avb)) {

            client.getCard().getAccount().setAvaliableBalance(avb - amount);
            avb= client.getCard().getAccount().getAvaliableBalance();

            client.getCard().getAccount().setHistory("/n" + " MONEY OUT : R" +amount + " AND YOU NEW AVL BALANCE IS: R"+avb);

            System.out.println(client.getCard().getAccount().getHistory());
        }else {

            System.out.println("INSUFFICIENT AVAILABLE BALANCE");

        }

    }



}
