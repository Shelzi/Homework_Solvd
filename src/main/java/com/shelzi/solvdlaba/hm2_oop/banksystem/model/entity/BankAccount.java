package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.Objects;

public class BankAccount {
    private static long FAKE_ID = 1;
    private static final int DEFAULT_STARTING_VALUE = 0;

    private final long accountId;
    private final CurrencyId currencyId;
    private Currency currencyValue;

    public BankAccount(CurrencyId currencyId) {
        this.accountId = FAKE_ID++;
        this.currencyId = currencyId;
        this.currencyValue = new Currency(currencyId, DEFAULT_STARTING_VALUE);
    }

    public BankAccount(CurrencyId currencyId, Currency currencyValue) {
        this.accountId = FAKE_ID++;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountId == that.accountId && currencyId == that.currencyId && currencyValue.equals(that.currencyValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, currencyId, currencyValue);
    }

    @Override
    public String toString() {
        return "\n\t\tBankAccount{" +
                "accountId=" + accountId +
                ", currencyId=" + currencyId +
                ", currencyValue=" + currencyValue +
                '}';
    }
}