package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity;

import java.util.Objects;

public abstract class Person {
    private static long FAKE_ID = 1;

    private final long id;
    private String fullName; // not sure about making it not final
    private short age;
    public Person(String fullName, short age) {
        id = FAKE_ID++;
        this.fullName = fullName;
        this.age = age;
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

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                fullName.equals(person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        return "\n\tPerson{" +
                "id=" + id +
                ", fullName='" + fullName + '\'';
    }
}