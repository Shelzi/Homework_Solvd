package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Person;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;

public interface BankService {
    boolean createBankAccount(Bank bank, long personId, CurrencyId currencyId) throws ServiceException;

    boolean addPerson(Bank bank, Person person);
}