package com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customer extends Person {
    private Set<Credit> credits;
    private Set<BankAccount> bankAccounts;
    private double creditRating;

    public Customer(String fullName, short age, Set<Credit> credits, Set<BankAccount> bankAccounts, double creditRating) {
        super(fullName, age);
        this.credits = credits;
        this.bankAccounts = bankAccounts;
        this.creditRating = creditRating;
    }

    public Customer(Person person, Set<Credit> credits, Set<BankAccount> bankAccounts, double creditRating) {
        this(person.getFullName(), person.getAge(), credits, bankAccounts, creditRating);
    }

    public Customer(String fullName, short age) {
        super(fullName, age);
        credits = new HashSet<>();
        bankAccounts = new HashSet<>();
    }

    public Customer(Person person) {
        this(person.getFullName(), person.getAge());
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

    public double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(double creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(credits, customer.credits)
                && Objects.equals(bankAccounts, customer.bankAccounts)
                && creditRating == customer.creditRating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), credits, bankAccounts, creditRating);
    }

    @Override
    public String toString() {

        return super.toString() + ", \n\tcredits=" + credits +
                ", \n\tbankAccounts=" + bankAccounts +
                ", \n\tcreditRating=" + creditRating +
                '}';
    }
}