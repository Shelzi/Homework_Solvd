package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Customer;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankServiceImpl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class CustomerGeneratorImpl implements Generator<Customer> {
    private static final int DEFAULT_MAX_CREDIT_NUMBER = 2;
    private static final int DEFAULT_MAX_BANK_ACCOUNT_NUMBER = 3;
    private static final BankService bankService = BankServiceImpl.getInstance();

    @Override
    public Set<Customer> generate(int amountOfCustomers) {
        Set<Customer> customerSet = new HashSet<>();
        for (int i = 0; i < amountOfCustomers; i++) {
            customerSet.add(generateCustomer(i));
        }
        return customerSet;
    }

    private Customer generateCustomer(int number) {
        Random random = new Random();
        Customer customer = new Customer("Name of Customer #" + number,
                (short) number);
        customer.setCreditRating(random.nextDouble() * 100);
        customer.setBankAccounts(new BankAccountGenerator().generate(
                random.nextInt(DEFAULT_MAX_BANK_ACCOUNT_NUMBER) + 1));
        if (bankService.isCreditAvailable(customer)) {
            customer.setCredits(new CreditGenerator().generate(random.nextInt(DEFAULT_MAX_CREDIT_NUMBER) + 1));
        }
        return customer;
    }
}