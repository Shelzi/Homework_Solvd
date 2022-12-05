package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bank implements Comparable<Bank>{
    private final String name;
    private final String country;
    private final Set<CurrencyId> availableCurrency; // not sure about final
    private Set<Customer> clientsSet;

    public Bank(String name, String country, Set<CurrencyId> availableCurrency, Set<Customer> clientsSet) {
        this.name = name;
        this.country = country;
        this.availableCurrency = availableCurrency;
        this.clientsSet = clientsSet;
    }

    public Bank(String name, String country, Set<CurrencyId> availableCurrency) {
        this(name, country, availableCurrency, new HashSet<>());
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Set<CurrencyId> getAvailableCurrency() {
        return availableCurrency;
    }

    public Set<Customer> getClientsSet() {
        return clientsSet;
    }

    public void setClientsSet(Set<Customer> clientsSet) {
        this.clientsSet = clientsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank other = (Bank) o;
        return (this.name != null ? this.name.equals(other.name) : other.name == null) // this
                && (this.country != null ? this.country.equals(other.country) : other.country == null) // and also this can be an Objects.equals(), i know
                && (this.availableCurrency.equals(other.availableCurrency))
                && (this.clientsSet.equals(other.clientsSet));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, availableCurrency, clientsSet);
    }

    @Override
    public String toString() {
        return "\nBank{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", availableCurrency=" + availableCurrency.toString() +
                ", clientsSet=" + clientsSet.toString() +
                '}';
    }

    @Override
    public int compareTo(Bank o) {
        return name.compareTo(o.name);
    }
}