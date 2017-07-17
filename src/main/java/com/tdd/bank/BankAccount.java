package com.tdd.bank;

import java.math.BigDecimal;

/**
 * Created by Steve.Katra on 7/17/2017.
 */
public abstract class BankAccount {
    protected BigDecimal balance;

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public abstract void withdraw(BigDecimal withdraw);

    public void deposit(BigDecimal depositAmount) {
        this.balance = this.balance.add(depositAmount);
    }
}
