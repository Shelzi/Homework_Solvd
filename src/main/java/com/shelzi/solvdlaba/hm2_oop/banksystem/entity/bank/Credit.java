package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.entity.bank;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.entity.currency.Currency;

import java.time.LocalDate;

public class Credit {
    private final Currency value;
    private final double interestRate; // not sure about final
    private final LocalDate creditCreationDate;
    private final int duration;

    public Credit(Currency value, double interestRate, int duration) {
        this.value = value;
        this.interestRate = interestRate;
        this.duration = duration;
        creditCreationDate = LocalDate.now();
    }

    public Currency getValue() {
        return value;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public LocalDate getCreditCreationDate() {
        return creditCreationDate;
    }

    public int getDuration() {
        return duration;
    }
}