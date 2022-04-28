package com.atm.entity;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class AccountTest extends TestCase {

    Account account = new Account(12356,1000,new StringBuilder("NEWLY OPENNED ACCOUNT"));

    @Test
    @DisplayName("TEST GET ACCOUNT NUMBER FUNCTIONALITY")
    public void testGetAccountNumber() {

        long acN = account.getAccountNumber();

        assertEquals(12356,acN);
    }

    @Test
    @DisplayName("TEST SET ACCOUNT NUMBER FUNCTIONALITY")
    public void testSetAccountNumber() {
        account.setAccountNumber(1235);

        assertEquals(1235,account.getAccountNumber());
    }

    @Test
    @DisplayName("TEST GET AVAILABLE BALANCE FUNCTIONALITY")
    public void testGetAvaliableBalance() {

        double bal = account.getAvaliableBalance();

        assertEquals(1000.0,bal);
    }

    @Test
    @DisplayName("TEST SET AVAILABLE BALANCE FUNCTIONALITY")
    public void testSetAvaliableBalance() {

        account.setAvaliableBalance(1000+850);

        assertEquals(1850.0,account.getAvaliableBalance());
    }

    @Test
    @DisplayName("TEST GET ACCOUNT STATEMENT FUNCTIONALITY")
    public void testGetHistory() {



        assertNotNull(account.getHistory());
    }

    @Test
    @DisplayName("TEST SET ACCOUNT STATEMENT  FUNCTIONALITY")
    public void testSetHistory() {

        account.setHistory(account.getHistory().append(" \n AMOUNT WITHDRAWAL \n"));

        assertNotNull(account.getHistory());
    }
}