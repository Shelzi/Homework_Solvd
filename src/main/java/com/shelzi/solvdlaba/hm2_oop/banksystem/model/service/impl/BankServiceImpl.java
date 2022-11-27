package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Person;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;

import java.util.Optional;
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
        if (bank.getAvailableCurrency().contains(currencyId)){
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

    @Override`
    public boolean addPerson(Bank bank, Person person) {
        return false;
    }
}
