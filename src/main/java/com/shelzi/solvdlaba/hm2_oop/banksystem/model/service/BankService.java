package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.*;

public interface BankService {
    BankAccount createBankAccount(Bank bank, Customer customer, CurrencyId currencyId) throws ServiceException;

    boolean addCustomer(Bank bank) throws ServiceException;

    Customer findCustomerByFullName(Bank bank, String name) throws ServiceException;

    Credit createCredit(Bank bank,
                        Customer customer,
                        CurrencyId currencyId,
                        Currency value, int duration, double interestRate) throws ServiceException;

    boolean isCreditAvailable(Customer customer);
}