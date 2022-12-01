package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.Random;

public enum CurrencyId {
    BYN,
    USD,
    EURO;

    private static final Random PRNG = new Random();

    public static CurrencyId randomCurrencyId()  {
        CurrencyId[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}