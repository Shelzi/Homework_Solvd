package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customer extends Person {
    private Set<Credit> credits;
    private Set<BankAccount> bankAccounts;

    public Customer(String fullName, short age, Set<Credit> credits, Set<BankAccount> bankAccounts) {
        super(fullName, age);
        this.credits = credits;
        this.bankAccounts = bankAccounts;
    }

    public Customer(Person person, Set<Credit> credits, Set<BankAccount> bankAccounts) {
        this(person.getFullName(), person.getAge(), credits, bankAccounts);
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

    @Override
    public boolean isCreditAvailable() {
        return true; //because Merry Christmas!
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(credits, customer.credits)
                && Objects.equals(bankAccounts, customer.bankAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), credits, bankAccounts);
    }

    @Override
    public String toString() {
        return ", credits=" + credits +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}