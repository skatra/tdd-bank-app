package com.tdd.bank;

import java.math.BigDecimal;

/**
 * Created by Steve.Katra on 7/17/2017.
 */
public class SavingAccount extends BankAccount {
    public SavingAccount() {
        this.balance = BigDecimal.valueOf(0.00);
    }

    public void withdraw(BigDecimal withdraw) {
        if(-1 == getBalance().compareTo(withdraw)) {
            throw new RuntimeException("Insufficient Funds");
        } else {
            this.balance = this.balance.subtract(withdraw);
        }
    }
}
