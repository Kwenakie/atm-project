package com.atm.app;

import com.atm.application.AtmHelperApplication;
import com.atm.entity.Account;
import com.atm.entity.Card;
import com.atm.entity.Client;
import java.util.Scanner;



public class AtmMainApp {



        static Scanner in = new Scanner(System.in);


    public static void main(String [] args){

        AtmHelperApplication atm = new AtmHelperApplication();

        System.out.println("WELCOME TO KWENA ATM  PLEASE ENTER YOUR CARD NUMBER AND PIN TO ACCESS ALL YOUR SERVICES");
        System.out.println("PLEASE NOTE!!! IF YOU ENTER WRONG PIN 3 TIMES YOUR SESSION WILL BE ENDED");




        Client client =null;

        int pintrys=3;

        long cardNumber;
        int pin;

        long theCardNumber= -1;

        System.out.println("ENTER YOUR CARD NUMBER: ");
        cardNumber = in.nextLong();

        String results = "ENTERED CARD NUMBER IS NOT CORRECT GET A CORRECT CARD NUMBER AND COME ENJOY KWENA ATM";
        for (Card card: atm.getCards()) {

            if (card.getCardNumber()==cardNumber){
                theCardNumber =cardNumber;
                results = "CARD NUMBER CORRECTLY ENTERED";
                break;
            }
        }

        System.out.println(results);
        System.out.println("ENTER YOUR CARD PIN: ");
        pin= in.nextInt();

        if (theCardNumber !=-1) {

            while (pintrys > 0) {

                if(atm.login(theCardNumber,pin)==null){


                    System.out.println("WRONG PIN ENTERED AND YOUR REMAINING TRIES ARE " + pintrys);

                    System.out.println("ENTER YOUR PIN AGAIN");
                    pin =in.nextInt();
                }else {

                    client =atm.login(theCardNumber,pin);
                    System.out.println("SUCCESSFULLY LOGGED IN");
                    break;
                }

                pintrys-=1;


            }

        }

        if(client!=null) {
            int actiom;

       displayMenu();

            System.out.println("ENTER  your selected Action");

            actiom = in.nextInt();

             do {
                 selectAndPerformAction(client,atm,actiom);


                 System.out.println("====================================================");
                 System.out.println("THESE ARE ACTIONS YOU CAN PERFORM IN MY ATM : " + "\n"
                         + " TO WITHDRAW PRESS 1 " + "\n"
                         + " TO DEPOSIT TO ANY OF YOUR LINKED ACCOUNT ENTER 2: " + "\n"
                         + " TO CHECK ANY OF YOU ACCOUNT BALANCE ENTER 3: " + "\n"
                         + " TO GET ANY ACCOUNT STATEMENT ENTER 4 :" + "\n"
                         + " TO CHANGE YOUR ACCOUNT PIN ENTER 5:" + "\n"
                         + " TO PERFORM INTER ACCOUNT TRANSFER ENTER 6" + "\n"
                         + " TO EXIT ENTER ZERO");
                 System.out.println("====================================================");

                 System.out.println("PLEASE ENTER YOUR NEXT OPTION NB:! SELECT OPTION ZERO TO EXIT THE ATM");
                 actiom =in.nextInt();

             }
            while (actiom!=0);



        }


    }


    //display full menu
    public static void selectAndPerformAction(Client client ,AtmHelperApplication atm,int action){

        if (client!=null){



            switch (action){

                case 1:
                    withdrawal(client, atm);
                    break;
                case 2:
                    deposit(client,atm);
                    break;
                case 3:
                    getbalance(client,atm);
                    break;
                case 4:
                    getStatement(client,atm);
                    break;
                case 5:
                    changePin(client,atm);
                    break;
                case 6:
                    doInterAccountTransfer(client,atm);
                    break;
                case 0:
                    System.out.println("===========================THANK YOU FOR USING MY ATM PLEASE  DO CALL AGAIN=================");
                    break;

                default: System.out.println("You Have Entered an Incorrect Option");
                break;
            }
        }
    }

    private static void doInterAccountTransfer(Client client, AtmHelperApplication atm) {

        System.out.println("ENTER AN ACCOUNT MATCHING YOUR SHOWN BELOW ACCOUNTS FOR WHICH YOU WISH TO TRANSFER FROM");
        long toAccountNum;
        long fromAccountNum;
        for (Account account: client.getAccount() ) {

            System.out.println(account.getAccountNumber());
        }
        System.out.println("ENTER AN ACCOUNT MATCHING YOUR SHOWN ABOVE ACCOUNTS FOR WHICH YOU WISH TO TRANSFER FROM");
        fromAccountNum =in.nextLong();

        System.out.println("ENTER AN ACCOUNT MATCHING YOUR SHOWN ABOVE ACCOUNTS FOR WHICH YOU WISH TO TRANSFER TO");
        toAccountNum =in.nextLong();

        System.out.println("ENTER THE AMOUNT YOU WISH TO TRANSFER");
        double amount;

        amount=in.nextDouble();

        atm.doMoneyTransfer(client,toAccountNum,fromAccountNum,amount);

    }


    private static void changePin(Client client , AtmHelperApplication atm) {

        int newPin;
        System.out.println("ENTER A NEW 4 DIGIT PIN : ");
        newPin =in.nextInt();

        atm.setCardPin(client,newPin);
    }

    private static void getStatement(Client client, AtmHelperApplication atm) {

        System.out.println("ENTER AN ACCOUNT MATCHING YOUR SHOWN BELOW ACCOUNTS FOR WHICH YOU WISH TO GET THE STATEMENT");
        long accountNum;
        for (Account account: client.getAccount() ) {

            System.out.println(account.getAccountNumber());
        }

        accountNum =in.nextLong();

        System.out.println(atm.getAccountStatement(client,accountNum));

    }

    private static void getbalance(Client client, AtmHelperApplication atm) {

        System.out.println("ENTER AN ACCOUNT MATCHING YOUR SHOWN BELOW ACCOUNTS FOR WHICH YOU WISH TO GET YOUR DEPOSIT");
        long accountNum;
        for (Account account: client.getAccount() ) {

            System.out.println(account.getAccountNumber());
        }

        accountNum =in.nextLong();

        System.out.println("YOUR AVAILABLE AMOUNT FOR SELECTED ACCOUNT : " + accountNum + " IS: R" +atm.getAccountBalances(client,accountNum));
    }

    private static void deposit(Client client, AtmHelperApplication atm) {
        double amount ;

        System.out.println("ENTER AN ACCOUNT MATCHING YOUR SHOWN BELOW ACCOUNTS FOR WHICH YOU WISH TO GET THE STATEMENT");
        long accountNum;
        for (Account account: client.getAccount() ) {

            System.out.println(account.getAccountNumber());
        }

        accountNum= in.nextLong();

        System.out.println("ENTER THE AMOUNT YOU WISH TO DEPOSIT");
        amount =in.nextDouble();


        atm.performAccountDeposit(client,accountNum,amount);

    }

    private static void withdrawal(Client client, AtmHelperApplication atm) {

        double amount;

        System.out.println("ENTER YOUR WITHDRAWAL AMOUNT : " );
        amount =in.nextDouble();

        atm.performWithdrawal(client,amount);


    }

    //display main menu
    public static void displayMenu(){
        System.out.println("====================================================");
        System.out.println("THESE ARE ACTIONS YOU CAN PERFORM IN MY ATM : " + "\n"
                + " TO WITHDRAW PRESS 1 " + "\n"
                + " TO DEPOSIT TO ANY OF YOUR LINKED ACCOUNT ENTER 2: " + "\n"
                + " TO CHECK ANY OF YOU ACCOUNT BALANCE ENTER 3: " + "\n"
                + " TO GET ANY ACCOUNT STATEMENT ENTER 4 :" + "\n"
                + " TO CHANGE YOUR ACCOUNT PIN ENTER 5:" + "\n"
                + " TO PERFORM INTER ACCOUNT TRANSFER ENTER 6" + "\n"
                + " TO EXIT ENTER ZERO");
        System.out.println("====================================================");
    }
}
