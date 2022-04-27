package com.atm.application;

import com.atm.entity.Account;
import com.atm.entity.Card;
import com.atm.entity.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AtmHelperApplication {

    private List<Account> accounts = new ArrayList();

    private List<Account> accounts1 = new ArrayList();

    private List<Account> accounts2 = new ArrayList();
    private List<Client> clients = new ArrayList();

    private List<Card>cards = new ArrayList();



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

        Client cl1 = new Client(1212,"Kwena" , "Mbayeka" ,"female","African","23 sonneblom",accounts, c1);
        Client cl2 = new Client(1213,"Khumo" , "Mbayeka" , "male","African","510 sosha",accounts1, c2);
        Client cl3 = new Client(1214,"Mntungwa" , "Nkosi" , "male","Indian","23 sonneblom",accounts2, c3);



        clients.add(cl1);
        clients.add(cl2);
        clients.add(cl3);

    }



    //need reword
    public Client login(long cardNumber , int pin){


        Client theClient =null;
        try {
        for (Card card : cards) {
            if (card.getCardNumber() == cardNumber) {
                Client c = getClientGivenCardNumber(cardNumber);
                if (c != null) {
                if (c.getCard().getCardPin() == pin) {
                    theClient = c;
                    break;
                }
            }
        }
    }
        }catch (NullPointerException e){
            System.out.println("LOGIN FAILED");

        }
        return theClient;

    }

    //get client given card number
    public Client getClientGivenCardNumber(long cardNumber){
        Client client= null;

        try {


        for (Client theclient:clients) {

            if(theclient.getCard().getCardNumber()==cardNumber){
                client =theclient;
                break;
            }

        }
        }catch (NullPointerException e){

            System.out.println("UNABLE TO FIND CLIENT WITH THE GIVEN CARD NUMBER");
        }

        return client;
    }


    //perform account Deposit
    public void performAccountDeposit(Client client,long  accountNumber,double amount){

        Account acc = client.getAnAccount(accountNumber) ;

        if(acc!=null){
        double balance = acc.getAvaliableBalance();
            acc.setAvaliableBalance(amount+balance);
            acc.setHistory("ATM MONEY IN : R"+amount + " ON " + LocalDateTime.now() + "\n");
            System.out.println("MONEY IN : R" +amount + " AND NEW AVAILABLE BALANCE IS :R" + acc.getAvaliableBalance());
        }else {

            System.out.println("ACCOUNT DOESN'T EXIST");
        }

    }

    //perform account Withdrawal
    public void performWithdrawal( Client client,double amount){



        double avb= client.getCard().getAccount().getAvaliableBalance();

        if((amount <= avb)) {

            client.getCard().getAccount().setAvaliableBalance(avb - amount);
            avb= client.getCard().getAccount().getAvaliableBalance();

            client.getCard().getAccount().setHistory(" MONEY OUT : R" +amount + " AND YOU NEW AVL BALANCE IS: R"+avb + " TIME :" + LocalDateTime.now() +"\n");

            System.out.println(client.getCard().getAccount().getHistory());
        }else {

            System.out.println("INSUFFICIENT AVAILABLE BALANCE");

        }

    }

    //perform monery transfer
    public void doMoneyTransfer(Client client, long toAccount, long fromAccount , double amount){

        double bal1= client.getAnAccount(fromAccount).getAvaliableBalance();
        double bal2 = client.getAnAccount(toAccount).getAvaliableBalance();
        if(amount <= bal1){

            client.getAnAccount(fromAccount).setAvaliableBalance(bal1-amount);
            client.getAnAccount(fromAccount).setHistory("\n" + "MONEY OF AMOUNT : R"+amount +   " TRANSFER TO : " + toAccount + "TIME :" + LocalDateTime.now() +"\n");
            bal2 += amount;
            client.getAnAccount(toAccount).setAvaliableBalance(bal2);
            client.getAnAccount(fromAccount).setHistory("\n" + "MONEY TRANSFER IN: R"+amount +   " AND YOUR NEW BALANCE IS R : " +bal2 + " TIME " + LocalDateTime.now() +"\n");

            System.out.println("YOUR NEW AVAILABLE BALANCE FOR ACCNUMBER " + toAccount + " IS : " +  "R"+ client.getAnAccount(toAccount).getAvaliableBalance());
            System.out.println("YOUR NEW AVAILABLE BALANCE FOR ACCNUMBER " + fromAccount + " IS : " +  "R"+ client.getAnAccount(fromAccount).getAvaliableBalance());

        }

    }

    //get statement
    public String  getAccountStatement(Client client, long accountNum ){

        return client.getAnAccount(accountNum).getHistory();
    }

   //get account Balance
    public double getAccountBalances(Client client, long accountNumber){

        return client.getAnAccount(accountNumber).getAvaliableBalance();
    }

    //change pin given the new pin
    public void setCardPin(Client client, int newPin){


        try {

            client.getCard().setCardPin(newPin);
            System.out.println("YOUR CARD PIN HAS BEEN SUCCESSFULLY CHANGED");
            client.getAnAccount(client.getCard().getCardNumber()).setHistory(" YOU CHANGED YOUR CARD PIN " + "TIME: " + LocalDateTime.now() +"\n");
        } catch (NullPointerException e){
            System.out.println("UNABLE TO GET ACCOUNT HISTORY");
        }

    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts1() {
        return accounts1;
    }

    public void setAccounts1(List<Account> accounts1) {
        this.accounts1 = accounts1;
    }

    public List<Account> getAccounts2() {
        return accounts2;
    }

    public void setAccounts2(List<Account> accounts2) {
        this.accounts2 = accounts2;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
