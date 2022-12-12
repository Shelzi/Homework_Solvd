package com.shelzi.solvdlaba.hm2_oop.banksystem.model.service;

import com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;

public interface BankAccountService {
    void withdraw(BankAccount bankAccount, Currency amount) throws ServiceException;

    void deposit(BankAccount bankAccount, Currency amount) throws ServiceException;
}