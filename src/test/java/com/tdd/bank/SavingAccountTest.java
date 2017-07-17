package com.tdd.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Steve.Katra on 7/17/2017.
 */
public class SavingAccountTest {
    private SavingAccount savingAccount;

    @BeforeEach
    void setUp() {
        savingAccount = new SavingAccount();
        assertEquals(BigDecimal.valueOf(0.00), savingAccount.getBalance());
    }

    @Test
    void shouldHoldBalance() {
        savingAccount.setBalance(BigDecimal.valueOf(10.21));
        assertEquals(BigDecimal.valueOf(10.21), savingAccount.getBalance());
    }

    @Test
    void shouldBeAbleToWidthdraw() {
        savingAccount.setBalance(BigDecimal.valueOf(10.21));
        savingAccount.withdraw(BigDecimal.valueOf(5.00));
        assertEquals(BigDecimal.valueOf(5.21), savingAccount.getBalance());
    }

    @Test
    void shouldBeAbleToDeposit() {
        savingAccount.deposit(BigDecimal.valueOf(5.21));
        assertEquals(BigDecimal.valueOf(5.21), savingAccount.getBalance());
    }

    @Test
    void shouldChargeFiveDollarFeeForOverdraft() {
        Throwable exception = assertThrows(RuntimeException.class, ()-> {
            savingAccount.withdraw(BigDecimal.valueOf(5.00));
        });
        assertEquals("Insufficient Funds", exception.getMessage());
    }

}
