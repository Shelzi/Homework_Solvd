package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.Set;

public class Person {
    private static long FAKE_ID = 1;

    private final long id;
    private String fullName; // not sure about making it not final
    private Set<Credit> credits;
    private Set<BankAccount> bankAccounts;

    public Person(String fullName, Set<Credit> credits, Set<BankAccount> bankAccounts) {
        id = FAKE_ID++;
        this.fullName = fullName;
        this.credits = credits;
        this.bankAccounts = bankAccounts;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Credit> getCredits() {
        return credits;
    }

    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}