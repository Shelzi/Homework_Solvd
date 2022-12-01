package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Customer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class CustomerGeneratorImpl implements Generator<Customer> {
    private static final int DEFAULT_MAX_CREDIT_NUMBER = 2;
    private static final int DEFAULT_MAX_BANK_ACCOUNT_NUMBER = 3;

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
        return new Customer("Name of Customer #" + number,
                (short) number,
                new CreditGenerator().generate(random.nextInt(DEFAULT_MAX_CREDIT_NUMBER) + 1),
                new BankAccountGenerator().generate(random.nextInt(DEFAULT_MAX_BANK_ACCOUNT_NUMBER) + 1));
    }
}