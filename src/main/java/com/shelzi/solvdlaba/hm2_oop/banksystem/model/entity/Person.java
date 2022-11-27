package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    private static long FAKE_ID = 1;

    private final long id;
    private String fullName; // not sure about making it not final
    private Set<Credit> credits;
    private Set<BankAccount> bankAccounts;

    public Person(String fullName) {
        id = FAKE_ID++;
        this.fullName = fullName;
        this.credits = new HashSet<>();
        this.bankAccounts = new HashSet<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                fullName.equals(person.fullName) &&
                credits.equals(person.credits) &&
                bankAccounts.equals(person.bankAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, credits, bankAccounts);
    }

    @Override
    public String toString() {
        return "\n\tPerson{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", credits=" + credits +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}