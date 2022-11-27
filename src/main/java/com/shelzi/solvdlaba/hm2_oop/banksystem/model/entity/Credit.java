package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Credit {
    private static long FAKE_ID = 1;

    private final long creditId;
    private final CurrencyId currencyId;
    private final Currency value;
    private final double interestRate; // not sure about final
    private final LocalDate creditCreationDate;
    private final int duration;

    public Credit(long creditId, CurrencyId currencyId, Currency value, double interestRate, int duration) {
        this.currencyId = currencyId;
        this.creditId = FAKE_ID++;
        this.value = value;
        this.interestRate = interestRate;
        this.duration = duration;
        creditCreationDate = LocalDate.now();
    }

    public long getCreditId() {
        return creditId;
    }

    public CurrencyId getCurrencyId() {
        return currencyId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit other = (Credit) o;
        return creditId == other.creditId
                && Double.compare(other.interestRate, interestRate) == 0
                && duration == other.duration
                && currencyId == other.currencyId
                && value.equals(other.value)
                && creditCreationDate.equals(other.creditCreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, currencyId, value, interestRate, creditCreationDate, duration);
    }

    @Override
    public String toString() {
        return "\nCredit{" +
                "creditId=" + creditId +
                ", currencyId=" + currencyId +
                ", value=" + value +
                ", interestRate=" + interestRate +
                ", creditCreationDate=" + creditCreationDate +
                ", duration=" + duration +
                '}';
    }
}