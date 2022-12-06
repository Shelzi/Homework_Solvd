package main.java.com.shelzi.solvdlaba.hm2_oop;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl.BankGeneratorImpl;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Customer;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankAccountService;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankAccountServiceImpl;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankServiceImpl;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Runner {
    private static final BankService bankService;
    private static final BankAccountService bankAccountService;
    private static final Generator<Bank> bankGenerator;
    private static final Logger logger;

    static {
        bankService = BankServiceImpl.getInstance();
        bankAccountService = BankAccountServiceImpl.getInstance();
        bankGenerator = BankGeneratorImpl.getInstance();
        logger = LogManager.getRootLogger();
    }

    public static void main(String[] args) {
        List<Bank> bankList = bankGenerator.generate(3).stream().sorted(Bank::compareTo).toList();
        logger.log(Level.INFO, bankList);
        try {
            //Customer customer = bankService.findCustomerByFullName(bankList.get(0), "Invalid Name"); // Exception from lower method
            Customer customer = bankService.findCustomerByFullName(bankList.get(0), "Name of Customer #0"); // No exception

            logger.log(Level.INFO, customer.getBankAccounts());

            bankAccountService.deposit(customer.getBankAccounts().stream().toList().get(0), //or withdraw
                    new Currency(CurrencyId.USD, 2147483647));                         //or change currencyId type

            logger.log(Level.INFO, customer.getBankAccounts());
        } catch (ServiceException e) {
            logger.log(Level.WARN, e);
        }
    }
}