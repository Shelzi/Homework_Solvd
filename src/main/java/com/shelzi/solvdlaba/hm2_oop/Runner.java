package com.shelzi.solvdlaba.hm2_oop;

import com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl.BankGeneratorImpl;
import com.shelzi.solvdlaba.hm2_oop.banksystem.linkedlistimpl.CustomLinkedList;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Customer;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankAccountService;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankAccountServiceImpl;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankServiceImpl;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    private static final BankService bankService = BankServiceImpl.getInstance();
    private static final BankAccountService bankAccountService = BankAccountServiceImpl.getInstance();
    private static final Generator<Bank> bankGenerator = BankGeneratorImpl.getInstance();
    private static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {

        try { Map<String, Integer> wordsCount = new HashMap<>();
            for (String s : Arrays.stream(StringUtils.split(FileUtils.readFileToString(new File("src/main/resources/in.txt"), StandardCharsets.UTF_8.name()), " |\\,|\\.|\\!|\\?|\\(|\\)|\\[|\\]|\\;|\\:|\\|\\\n|\\\r|\\\t")).toList()) {wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);} // //get input from file and counting
            for (Map.Entry<String, Integer> e : wordsCount.entrySet()) {FileUtils.writeStringToFile(new File("src/main/resources/out.txt"), e.getKey() + " : " + e.getValue() + "\n", StandardCharsets.UTF_8.name(), true);} // write result to output file
        } catch (IOException e){ throw new RuntimeException(e);}

        /*Bank a = bankGenerator.generate(1).stream().findAny().get();
        Bank b = bankGenerator.generate(1).stream().findAny().get();
        Bank c = bankGenerator.generate(1).stream().findAny().get();
        //test
        List<Bank> bankList = new CustomLinkedList<>();
        bankList.add(a);
        bankList.add(b);
        bankList.add(c);

        for (int i = 0; i < bankList.size(); i++) {
            logger.log(Level.INFO, bankList.get(i).hashCode());
        }
        System.out.println();

        logger.log(Level.INFO, bankList.get(0).hashCode() + "\n");

        bankList.remove(0);

        logger.log(Level.INFO, bankList.get(0).hashCode() + "\n");

        bankList.add(0, bankGenerator.generate(1).stream().findAny().get());

        logger.log(Level.INFO, bankList.get(0).hashCode() + "\n");

        for (int i = 0; i < bankList.size(); i++) {
            logger.log(Level.INFO, bankList.get(i).hashCode());
        }

        try {
            Customer customer = bankService.findCustomerByFullName(bankList.get(0), "Name of Customer #0");

            logger.log(Level.INFO, customer.getBankAccounts());

            bankAccountService.deposit(customer.getBankAccounts().stream().toList().get(0),
                    new Currency(CurrencyId.USD, 4000));

            logger.log(Level.INFO, customer.getBankAccounts());
        } catch (ServiceException e) {
            logger.log(Level.WARN, e);
        }*/
    }
}