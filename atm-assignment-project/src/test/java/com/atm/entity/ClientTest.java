package com.atm.entity;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class ClientTest extends TestCase {

    List<Account> accounts = new ArrayList();

    Account ac= new Account(12356,1000,new StringBuilder("NEWLY OPENNED ACCOUNT"));
    Account ac2= new Account(1489,2500,new StringBuilder("NEWLY OPENNED ACCOUNT"));
    Account ac3= new Account(25255,8000,new StringBuilder("NEWLY OPENNED ACCOUNT"));

    Card card = new Card(12560,1256,ac);


    @Test
    @DisplayName("TEST LOGIN FUNCTIONALITY")
    public void testGetAccount() {

        accounts.add(ac);
        accounts.add(ac2);
        accounts.add(ac3);

        Client client = new Client(1478,"Kwena","Mphahlele","Female","African","23 Cosmo road",accounts,card);

        List<Account> clientAccounts = client.getAccount();
        for (Account account: clientAccounts) {
            System.out.println("YOUR ACCOUNT NUMBER IS : " + account.getAccountNumber());
        }

        assertNotNull(clientAccounts);


    }

    @Test
    @DisplayName("TEST LOGIN FUNCTIONALITY")
    public void testSetAccount() {
    List <Account> newAccounts = new ArrayList();
        Account ac4= new Account(12386,1520,new StringBuilder("MODIFIED OPENNED ACCOUNT"));
        newAccounts.add(ac4);
        newAccounts.add(ac);


        Client client = new Client(1478,"Kwena","Mphahlele","Female","African","23 Cosmo road",newAccounts,card);

        client.setAccount(newAccounts);

        assertNotNull(client.getAccount());
    }

    @Test
    @DisplayName("TEST LOGIN FUNCTIONALITY")
    public void testGetCard() {

        accounts.add(ac);
        accounts.add(ac2);
        accounts.add(ac3);

        Client client = new Client(1478,"Kwena","Mphahlele","Female","African","23 Cosmo road",accounts,card);

        Card theCard = client.getCard();

        assertNotNull(theCard);
    }

    @Test
    @DisplayName("TEST LOGIN FUNCTIONALITY")
    public void testSetCard() {
        accounts.add(ac);
        accounts.add(ac2);
        accounts.add(ac3);

        Client client = new Client(1478,"Kwena","Mphahlele","Female","African","23 Cosmo road",accounts,card);

        Card card2 = new Card(12570,1256,ac2);
        client.setCard(card2);

        assertEquals(12570,client.getCard().getCardNumber());
    }

    @Test
    @DisplayName("TEST LOGIN FUNCTIONALITY")
    public void testGetAnAccount() {
        accounts.add(ac);
        accounts.add(ac2);
        accounts.add(ac3);

        Client client = new Client(1478,"Kwena","Mphahlele","Female","African","23 Cosmo road",accounts,card);

        Account accc = client.getAnAccount(1489);

        assertNotNull(accc);
    }
}