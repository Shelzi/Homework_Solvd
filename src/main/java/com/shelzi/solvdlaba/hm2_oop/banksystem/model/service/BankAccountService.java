package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;

public interface BankAccountService {
    void withdraw(BankAccount bankAccount, Currency amount) throws ServiceException;

    void deposit(BankAccount bankAccount, Currency amount) throws ServiceException;
}