package com.shelzi.solvdlaba.hm2_oop;

import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl.BankGeneratorImpl;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Customer;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankAccountService;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankAccountServiceImpl;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankServiceImpl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.LinkedList;
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