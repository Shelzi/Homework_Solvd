package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.entity.bank;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.entity.currency.CurrencyId;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.entity.currency.Currency;

public class BankAccount {
    private static long fake_id = 1;
    private static final int DEFAULT_STARTING_VALUE = 0;

    private final long accountId;
    private final CurrencyId currencyId;
    private Currency currencyValue;

    public BankAccount(CurrencyId currencyId) {
        this.accountId = fake_id++;
        this.currencyId = currencyId;
        this.currencyValue = new Currency(currencyId, DEFAULT_STARTING_VALUE);
    }

    public BankAccount(CurrencyId currencyId, Currency currencyValue) {
        this.accountId = fake_id++;
        this.currencyId = currencyId;
        this.currencyValue = currencyValue;
    }

    public long getAccountId() {
        return accountId;
    }

    public CurrencyId getCurrencyId() {
        return currencyId;
    }

    public Currency getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(Currency currencyValue) {
        this.currencyValue = currencyValue;
    }
}