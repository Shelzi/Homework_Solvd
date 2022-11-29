package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.*;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankServiceImpl implements BankService {
    private static final Lock LOCKER = new ReentrantLock();
    private static volatile BankService instance;


    private BankServiceImpl() {
    }

    public static BankService getInstance() {
        if (instance == null) {
            LOCKER.lock();
            if (instance == null) {
                instance = new BankServiceImpl();
            }
            LOCKER.unlock();
        }
        return instance;
    }

    @Override
    public BankAccount createBankAccount(Bank bank, Customer customer, CurrencyId currencyId) throws ServiceException {
        if (isBankCanUseCurrency(bank, currencyId)) {
            if (customer != null) {
                return new BankAccount(currencyId);
            } else {
                throw new ServiceException("No such customer in bank.");
            }
        } else {
            throw new ServiceException("No such available currency in bank.");
        }
    }

    private Person createPerson() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name and age of new person.");
        return new Customer(scan.nextLine(), scan.nextShort()); // only for this task
    }

    @Override
    public boolean addCustomer(Bank bank) throws ServiceException {
        Customer newCustomer = new Customer(createPerson());
        Optional<Customer> optionalCustomer = bank.getClientsSet().stream()
                .filter(p -> p.getFullName().equals(newCustomer.getFullName()))
                .findAny();
        if (optionalCustomer.isEmpty()) {
            bank.getClientsSet().add(newCustomer);
            return true;
        } else {
            throw new ServiceException("Customer already exist");
        }
    }

    @Override
    public Customer findCustomerByFullName(Bank bank, String name) throws ServiceException {
        Optional<Customer> optionalCustomer = bank.getClientsSet().stream()
                .filter(p -> p.getFullName().equals(name))
                .findAny();
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new ServiceException("Customer dont exist.");
        }
    }

    @Override
    public Credit createCredit(Bank bank,
                               Customer customer,
                               CurrencyId currencyId,
                               Currency value,
                               int duration, double interestRate) throws ServiceException {
        if (isBankCanUseCurrency(bank, currencyId) && customer.isCreditAvailable()) {
            return new Credit(currencyId, value, interestRate, duration);
        } else {
            throw new ServiceException("Can't give credit to this person.");
        }
    }

    private boolean isBankCanUseCurrency(Bank bank, CurrencyId currencyId) {
        return bank.getAvailableCurrency().contains(currencyId);
    }
}