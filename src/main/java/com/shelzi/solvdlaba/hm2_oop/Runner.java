package com.shelzi.solvdlaba.hm2_oop;

import com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl.BankGeneratorImpl;
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
import java.util.*;
import java.util.function.*;

public class Runner {
    private static final BankService bankService = BankServiceImpl.getInstance();
    private static final BankAccountService bankAccountService = BankAccountServiceImpl.getInstance();
    private static final Generator<Bank> bankGenerator = BankGeneratorImpl.getInstance();
    private static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {
        //prev HW
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : Arrays.stream(StringUtils.split(FileUtils.readFileToString(new File("src/main/resources/in.txt"), StandardCharsets.UTF_8.name()), " |\\,|\\.|\\!|\\?|\\(|\\)|\\[|\\]|\\;|\\:|\\|\\\n|\\\r|\\\t")).toList()) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        } // //get input from file and counting
        for (Map.Entry<String, Integer> e : wordsCount.entrySet()) {
            FileUtils.writeStringToFile(new File("src/main/resources/out.txt"), e.getKey() + " : " + e.getValue() + "\n", StandardCharsets.UTF_8.name(), true);
        } // write result to output file

        // first generic
        StringProcessor<String> stringProcessor = s -> StringUtils.repeat(s, 10);
        String str = "Cake is a lie. ";
        System.out.println(stringProcessor.process(str));

        //second generic
        List<Bank> bankList = bankGenerator.generate(5).stream().toList();
        BankComparator<Bank> specialBankComparator = Bank::compareTo;
        System.out.println(specialBankComparator.compareTo(bankList.get(1), bankList.get(0)));

        //last generic
        BankFunction<Bank, Customer> specialBankFunction = b -> b.getClientsSet().stream()
                .filter(p -> p.getFullName().equals("Name of Customer #0"))
                .findAny().get();
        System.out.println(specialBankFunction.apply(bankList.get(0)));

        //1
        BiFunction<Bank, String, Customer> findCustomerByName = (b, s) -> b.getClientsSet().stream()
                .filter(p -> p.getFullName().equals(s)).findAny().get();
        System.out.println(findCustomerByName.apply(bankList.get(0), "Name of Customer #0"));

        //2
        DoubleSupplier doubleSupplier = () -> 3.1415;
        System.out.println(doubleSupplier.getAsDouble());

        //3
        Predicate<Bank> predicate = bank -> bank.getClientsSet().isEmpty();
        System.out.println(predicate.test(bankList.get(0)));

        //4
        Consumer<Bank> showCustomerWithBestCreditRating = b -> System.out.println(b.getClientsSet().stream()
                .max(Comparator.comparingDouble(Customer::getCreditRating)).get());
        showCustomerWithBestCreditRating.accept(bankList.get(0));

        //5
        Function<List<Bank>, String> concatAllBanksNames = banks -> banks.stream()
                .map(Bank::getName)
                .reduce(", ", String::concat);
        System.out.println(concatAllBanksNames.apply(bankList));

        try {
            Customer customer = bankService.findCustomerByFullName(bankList.get(0), "Name of Customer #0");
            logger.log(Level.INFO, customer.getBankAccounts());
            bankAccountService.deposit(customer.getBankAccounts().stream().toList().get(0),
                    new Currency(CurrencyId.USD, 4000));
            logger.log(Level.INFO, customer.getBankAccounts());
        } catch (ServiceException e) {
            logger.log(Level.WARN, e);
        }
    }
}