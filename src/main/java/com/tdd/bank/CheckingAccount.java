package com.tdd.bank;

import java.math.BigDecimal;

/**
 * Created by Steve.Katra on 7/17/2017.
 */
public class CheckingAccount extends BankAccount {

    public CheckingAccount() {
        this.balance = BigDecimal.valueOf(0.00);
    }

    public void withdraw(BigDecimal withdraw) {
        if(-1 == getBalance().compareTo(withdraw)) {
            this.balance = this.balance.subtract(withdraw);
            this.balance = this.balance.subtract(BigDecimal.valueOf(5.00));
        } else {
            this.balance = this.balance.subtract(withdraw);
        }
    }
}
