package com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl;

import com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankAccountService;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountServiceImpl implements BankAccountService {
    private static final Lock locker = new ReentrantLock();
    private static volatile BankAccountService instance;

    private BankAccountServiceImpl() {
    }

    public static BankAccountService getInstance() {
        if (instance == null) {
            locker.lock();
            if (instance == null) {
                instance = new BankAccountServiceImpl();
            }
            locker.unlock();
        }
        return instance;
    }

    @Override
    public void withdraw(BankAccount bankAccount, Currency amount) throws ServiceException {
        int currency = bankAccount.getCurrencyValue().getValue();
        if (bankAccount.getCurrencyValue().getType().equals(amount.getType())) {
            if (!(currency < amount.getValue())) {
                bankAccount.setCurrencyValue(bankAccount.getCurrencyValue().sub(amount));
            } else {
                throw new ServiceException("Not enough money.");
            }
        } else {
            throw new ServiceException("Wrong currency type.");
        }
    }

    @Override
    public void deposit(BankAccount bankAccount, Currency amount) throws ServiceException {
        int currency = bankAccount.getCurrencyValue().getValue();
        if (bankAccount.getCurrencyValue().getType().equals(amount.getType())) {
            if (!(currency + amount.getValue() < currency)) {
                bankAccount.setCurrencyValue(bankAccount.getCurrencyValue().add(amount));
            } else {
                throw new ServiceException("Max value overflow.");
            }
        } else {
            throw new ServiceException("Wrong currency type.");
        }
    }
}