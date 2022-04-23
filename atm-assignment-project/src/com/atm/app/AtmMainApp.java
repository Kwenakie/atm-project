package com.atm.app;

import com.atm.application.AtmHelperApplication;
import com.atm.entity.Account;
import com.atm.entity.Card;
import com.atm.entity.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmMainApp {

    public static void main(String [] args){

        AtmHelperApplication atm = new AtmHelperApplication();

        long cardnum;
        int cardpin;
        double amount;

        Scanner in = new Scanner(System.in);

        System.out.println("ENTER YOU CARD NUMBER : ");
        cardnum = in.nextLong();

        System.out.println("ENTER YOU CARD PIN : ");
        cardpin = in.nextInt();

        System.out.println("ENTER YOU WITHDRAWAL  AMOUNT :");
        amount=in.nextDouble();

        atm.performWithdrawal(cardnum,cardpin,amount);
        atm.performAccountDeposit(cardnum,cardpin,1236,360.33);





    }
}
