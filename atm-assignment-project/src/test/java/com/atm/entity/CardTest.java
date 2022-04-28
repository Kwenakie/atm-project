package com.atm.entity;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class CardTest extends TestCase {

    Account ac = new Account(1234,2560.20,new StringBuilder("NEWLY OPENED ACCOUNT "  + "\n"));

    Card card = new Card(12560,1256,ac);

    @Test
    @DisplayName("TEST GET CARD NUMBER FUNCTIONALITY")
    public void testGetCardNumber() {

        long cardNumber=card.getCardNumber();
        assertEquals(12560,cardNumber);
    }

    @Test
    @DisplayName("TEST SET CARD NUMBER  FUNCTIONALITY")
    public void testSetCardNumber() {
        card.setCardNumber(14789);
        assertEquals(14789,card.getCardNumber());
    }

    @Test
    @DisplayName("TEST GET CARD PIN FUNCTIONALITY")
    public void testGetCardPin() {
        int pin =card.getCardPin();
        assertEquals(1256,pin);
    }

    @Test
    @DisplayName("TEST SET CARD PIN FUNCTIONALITY")
    public void testSetCardPin() {

        card.setCardPin(1234);

        assertEquals(1234, card.getCardPin());
    }
    @Test
    @DisplayName("TEST GET AN ACCOUNT LINKED TO CARD FUNCTIONALITY")
    public void testGetAccount() {

        Account ac = card.getAccount();

        assertNotNull(ac);
    }

    @Test
    @DisplayName("TEST SET AN ACCOUNT LINKED TO CARD  FUNCTIONALITY")
    public void testSetAccount() {
        Account ac = new Account(1478,8560,new StringBuilder("SET ACCOUNT"));

        card.setAccount(ac);

        assertEquals(1478,card.getAccount().getAccountNumber());
    }
}