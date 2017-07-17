package com.tdd.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Steve.Katra on 7/17/2017.
 */
public class CheckingAccountTest {
    private CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount();
        assertEquals(BigDecimal.valueOf(0.00),checkingAccount.getBalance());
    }

    @Test
    void shouldHoldBalance() {
        checkingAccount.setBalance(BigDecimal.valueOf(10.21));
        assertEquals(BigDecimal.valueOf(10.21), checkingAccount.getBalance());
    }

    @Test
    void shouldBeAbleToWidthdraw() {
        checkingAccount.setBalance(BigDecimal.valueOf(10.21));
        checkingAccount.withdraw(BigDecimal.valueOf(5.00));
        assertEquals(BigDecimal.valueOf(5.21), checkingAccount.getBalance());
    }

    @Test
    void shouldBeAbleToDeposit() {
        checkingAccount.deposit(BigDecimal.valueOf(5.21));
        assertEquals(BigDecimal.valueOf(5.21),checkingAccount.getBalance());
    }

    @Test
    void shouldChargeFiveDollarFeeForOverdraft() {
        checkingAccount.withdraw(BigDecimal.valueOf(5.00));
        assertEquals(BigDecimal.valueOf(-10.00),checkingAccount.getBalance());
    }
}
