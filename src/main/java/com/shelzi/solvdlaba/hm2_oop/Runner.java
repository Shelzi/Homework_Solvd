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
import java.lang.reflect.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.*;

public class Runner {
    private static final BankService bankService = BankServiceImpl.getInstance();
    private static final BankAccountService bankAccountService = BankAccountServiceImpl.getInstance();
    private static final Generator<Bank> bankGenerator = BankGeneratorImpl.getInstance();
    private static final Logger logger = LogManager.getRootLogger();

    private static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Customer> customerConstructor = Customer.class.getConstructor(String.class, short.class);
        Customer customer = customerConstructor.newInstance("Test name", (short) 22);
        logger.log(Level.INFO, "Call constructor by reflection api: " + customer);
        logger.log(Level.INFO, "Get constructor 'getFullName' modifiers by reflection api: " + customerConstructor.getModifiers());
        logger.log(Level.INFO, "Get parameter types of constructor 'getFullName' by reflection api: " + Arrays.toString(customerConstructor.getParameterTypes()));
        System.out.println();
    }

    private static void testMethods(Customer customer) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = customer.getClass().getMethod("getFullName");
        logger.log(Level.INFO, "Call method 'getFullName' by reflection api: " + method.invoke(customer));
        logger.log(Level.INFO, "Get method 'getFullName' return type by reflection api: " + method.getGenericReturnType());
        logger.log(Level.INFO, "Get method 'getFullName' modifiers by reflection api: " + method.getModifiers());
        logger.log(Level.INFO, "Get parameter types of method 'getFullName' by reflection api: " + Arrays.toString(method.getParameterTypes()));
        System.out.println();
    }

    private static void testFields(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getSuperclass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Object value = f.get(o);
            logger.log(Level.INFO, "Type of field by reflection api: " + f.getGenericType());
            logger.log(Level.INFO, "Value of field by reflection api: " + value);
            logger.log(Level.INFO, "Modifiers of field by reflection api: " + f.getModifiers());
            logger.log(Level.INFO, "Is field has final modifier by reflection api: " + Modifier.isFinal(f.getModifiers()));
            logger.log(Level.INFO, "Is field has static modifier by reflection api: " + Modifier.isStatic(f.getModifiers()));
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        testConstructor();
        Customer customer1 = new Customer("Anton Аполинарович Гайдзинов", (short) 99);
        testMethods(customer1);
        testFields(customer1);

        /*//second generic
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
        }*/
    }
}