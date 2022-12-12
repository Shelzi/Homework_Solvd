package com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import com.shelzi.solvdlaba.hm2_oop.banksystem.util.RoundMethod;

import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
public final class Currency implements Comparable<Currency> {
    private final int value;
    private final CurrencyId type;

    public Currency(CurrencyId type, int value) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public CurrencyId getType() {
        return type;
    }

    public Currency add(Currency currency) {
        return new Currency(currency.type, value + currency.value);
    }

    public Currency sub(Currency currency) {
        return new Currency(currency.type, value - currency.value);
    }

    public Currency mul(int k) {
        return new Currency(type, value * k);
    }

    public Currency mul(double k, RoundMethod roundMethod, int d) {
        return new Currency(type, roundMethod.round(value * k, d));
    }

    public Currency round(RoundMethod roundMethod, int d) {
        return new Currency(type, roundMethod.round(value, d));
    }

    @Override
    public int compareTo(Currency o) {
        return (value - o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency Currency = (Currency) o;
        return value == Currency.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("%s.%d %s", value / 100, value % 100, type);
    }
}