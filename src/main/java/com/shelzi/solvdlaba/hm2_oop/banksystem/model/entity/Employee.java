package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.Objects;

public class Employee extends Person {
    private String officeAddress;
    private String position;

    public Employee(String fullName, short age, String officeAddress, String position) {
        super(fullName, age);
        this.officeAddress = officeAddress;
        this.position = position;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean isCreditAvailable() {
        return true; // because benefits from company :)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return officeAddress.equals(employee.officeAddress)
                && position.equals(employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), officeAddress, position);
    }

    @Override
    public String toString() {
        return "officeAddress='" + officeAddress + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}