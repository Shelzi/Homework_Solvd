package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.CustomerAlreadyExistException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.NoSuchCustomerExistException;
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
    private static final int MIN_CREDIT_RATING = 50;

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
                throw new NoSuchCustomerExistException("No such customer in bank.");
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
            throw new CustomerAlreadyExistException("Customer already exist");
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
            throw new NoSuchCustomerExistException("Customer didn't exist!");
        }
    }

    @Override
    public Credit createCredit(Bank bank,
                               Customer customer,
                               CurrencyId currencyId,
                               Currency value,
                               int duration, double interestRate) throws ServiceException {
        if (isBankCanUseCurrency(bank, currencyId) && isCreditAvailable(customer)) {
            return new Credit(value, interestRate, duration);
        } else {
            throw new ServiceException("Can't give credit to this person.");
        }
    }

    public boolean isBankCanUseCurrency(Bank bank, CurrencyId currencyId) {
        return bank.getAvailableCurrency().contains(currencyId);
    }

    public boolean isCreditAvailable(Customer customer) {
        return customer.getCreditRating() >= MIN_CREDIT_RATING;
    }
}