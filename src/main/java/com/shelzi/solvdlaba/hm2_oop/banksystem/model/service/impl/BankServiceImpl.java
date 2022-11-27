package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Person;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankServiceImpl implements BankService {
    private static final Lock locker = new ReentrantLock();
    private static volatile BankService instance;

    private BankServiceImpl() {
    }

    public static BankService getInstance() {
        if (instance == null) {
            locker.lock();
            if (instance == null) {
                instance = new BankServiceImpl();
            }
            locker.unlock();
        }
        return instance;
    }

    @Override
    public boolean createBankAccount(Bank bank, long personId, CurrencyId currencyId) throws ServiceException {
        if (bank.getAvailableCurrency().contains(currencyId)) {
            Optional<Person> person = bank.getClientsSet()
                    .stream()
                    .filter(p -> p.getId() == personId).findAny();
            if (person.isPresent()) {
                person.get().getBankAccounts().add(new BankAccount(currencyId));
                return true;
            } else {
                throw new ServiceException("No such person in bank.");
            }
        } else {
            throw new ServiceException("No such available currency in bank.");
        }
    }

    private Person createPerson() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of new person");
        return new Person(scan.nextLine());
    }

    @Override
    public boolean addPerson(Bank bank) throws ServiceException {
        Person newPerson = createPerson();
        Optional<Person> optionalPerson = bank.getClientsSet().stream()
                .filter(p -> p.getFullName().equals(newPerson.getFullName()))
                .findAny();
        if (optionalPerson.isEmpty()) {
            bank.getClientsSet().add(newPerson);
            return true;
        } else {
            throw new ServiceException("Person already exist");
        }
    }

    @Override
    public Person findPersonByFullName(Bank bank, String name) throws ServiceException {
        Optional<Person> optionalPerson = bank.getClientsSet().stream()
                .filter(p -> p.getFullName().equals(name))
                .findAny();
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new ServiceException("Person dont exist.");
        }
    }
}