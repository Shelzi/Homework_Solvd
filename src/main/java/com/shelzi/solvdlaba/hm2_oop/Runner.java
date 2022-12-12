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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Runner {
    private static final BankService bankService = BankServiceImpl.getInstance();
    private static final BankAccountService bankAccountService = BankAccountServiceImpl.getInstance();
    private static final Generator<Bank> bankGenerator = BankGeneratorImpl.getInstance();
    private static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        LinkedList<Bank> bankList = new LinkedList<>(
                bankGenerator.generate(3).stream().sorted(Bank::compareTo).toList()
        );

        Map<String, Bank> bankMap = new HashMap<>();
        bankMap.put("alfabank", bankList.get(0));
        bankMap.put("priorbank", bankList.get(1));
        bankMap.put("mtbank", bankList.get(2));

        logger.log(Level.INFO, bankMap);

        try {
            Customer customer = bankService.findCustomerByFullName(bankMap.get("alfabank"), "Name of Customer #0");

            logger.log(Level.INFO, customer.getBankAccounts());

            bankAccountService.deposit(customer.getBankAccounts().stream().toList().get(0),
                    new Currency(CurrencyId.USD, 4000));

            logger.log(Level.INFO, customer.getBankAccounts());
        } catch (ServiceException e) {
            logger.log(Level.WARN, e);
        }
    }
}