package com.atm.application;

import com.atm.entity.Account;
import com.atm.entity.Card;
import com.atm.entity.Client;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class AtmHelperApplicationTest extends TestCase {


    AtmHelperApplication atm = new AtmHelperApplication();


    @Test
    @DisplayName("TEST LOGIN FUNCTIONALITY")
    public void testLogin() {

        Client theClient = atm.login(12367,1234);

    assertNotNull(theClient);

    }

    @Test
    @DisplayName("TEST GET CLIENT GIVEN THE CARD NUMBER  FUNCTIONALITY")
    public void testGetClientGivenCardNumber() {

        Client client = atm.getClientGivenCardNumber(1234);
        assertNotNull(client);
    }

    @Test
    @DisplayName("TEST ACCOUNT DEPOSIT  FUNCTIONALITY")
    public void testPerformAccountDeposit() {

        atm.performAccountDeposit(atm.login(12368,1235),1339,50000);

        assertEquals(300000.0,atm.login(12368,1235).getAnAccount(1339).getAvaliableBalance());
    }


    @Test
    @DisplayName("TEST ACCOUNT WITHDRAWAL FUNCTIONALITY")
    public void testPerformWithdrawal() {

        atm.performWithdrawal(atm.login(12368,1235),1339,50000);

        assertEquals(200000.0,atm.login(12368,1235).getAnAccount(1339).getAvaliableBalance());
    }

    @Test
    @DisplayName("TEST MONEY TRANSFER FUNCTIONALITY")
    public void testDoMoneyTransfer() {
        atm.doMoneyTransfer(atm.login(12368,1235),1437,1439,6000);

        assertEquals(31000.0,atm.getAccountBalances(atm.login(12368,1235),1437));
    }

    @Test
    @DisplayName("TEST GET ACCOUNT STATEMENT FUNCTIONALITY")
    public void testGetAccountStatement() {

        atm.performWithdrawal(atm.login(12368,1235),1339,50000);

        atm.getAccountStatement(atm.login(12368,1235),1339);

        assertEquals(atm.login(12368,1235).getAnAccount(1339).getHistory(),
                     atm.login(12368,1235).getAnAccount(1339).getHistory());

    }

    @Test
    @DisplayName("TEST GET ACCOUNT BALANCE  FUNCTIONALITY")
    public void testGetAccountBalances() {
        atm.getAccountBalances(atm.login(12369,1236),1437);

        assertEquals(25000.00,atm.getAccountBalances(atm.login(12369,1236),1437));
    }
}