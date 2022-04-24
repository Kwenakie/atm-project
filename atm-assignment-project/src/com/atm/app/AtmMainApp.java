package com.atm.app;

import com.atm.application.AtmHelperApplication;
import com.atm.entity.Card;
import com.atm.entity.Client;
import java.util.Scanner;



public class AtmMainApp {

    public static void main(String [] args){

        AtmHelperApplication atm = new AtmHelperApplication();

        System.out.println("WELCOME TO KWENA ATM  PLEASE ENTER YOUR CARD NUMBER AND PIN TO ACCESS ALL YOUR SERVICES");
        System.out.println("PLEASE NOTE!!! IF YOU ENTER WRONG PIN 3 TIMES YOUR SESSION WILL BE ENDED");


        Scanner in = new Scanner(System.in);

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


            System.out.println("THESE ARE ACTIONS YOU CAN PERFORM IN OUR ATM : " + "\n"
                    + " TO WITHDRAW PRESS 1 " + "\n"
                    + " TO DEPOSIT TO ANY OF YOUR LINKED ACCOUNT PRESS 2: " + "\n"
                    + " TO CHECK ANY OF YOU ACCOUNT BALANCE PRESS 3: " + "\n"
                    + " TO GET ANY ACCOUNT STATEMENT PRESS 4 :" + "\n"
                    + " TO CHANGE YOUR ACCOUNT PIN PRESS 5:" + "\n"
                    + " TO EXIT ENTER ZERO");

            System.out.println("ENTER  your selected Action");
            actiom = in.nextInt();
            logedInMenu(client, actiom);
        }


    }


    //display full menu
    public static void logedInMenu(Client client ,int action){

        if (client!=null){



            switch (action){

                case 1:
                    withdrawal();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    getbalance();
                    break;
                case 4:
                    getStatement();
                    break;
                case 5:
                    changePin();
                    break;
                case 0:
                    doExit();
                    break;
                default: System.out.println("You Have Entered an Incorrect Option");
            }
        }
    }

    private static void doExit() {
    }

    private static void changePin() {

    }

    private static void getStatement() {

    }

    private static void getbalance() {

    }

    private static void deposit() {

    }

    private static void withdrawal() {
    }
}
