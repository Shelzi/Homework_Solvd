package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Customer;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankServiceImpl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankGeneratorImpl implements Generator<Bank> {
    private static final Set<CurrencyId> DEFAULT_CURRENCY_SET = Set.of(CurrencyId.EURO, CurrencyId.USD, CurrencyId.BYN);
    private static final Lock LOCKER = new ReentrantLock();
    private static final Generator<Customer> customerGenerator = CustomerGeneratorImpl.getInstance();
    private static volatile Generator<Bank> instance;

    private final Random random = new Random(5);

    private BankGeneratorImpl() {
    }

    public static Generator<Bank> getInstance() {
        if (instance == null) {
            LOCKER.lock();
            if (instance == null) {
                instance = new BankGeneratorImpl();
            }
            LOCKER.unlock();
        }
        return instance;
    }

    @Override
    public Set<Bank> generate(int amountOfBanks) {
        return generate(amountOfBanks, random.nextInt() + 1);
    }

    private Set<Bank> generate(int amountOfBanks, int amountOfCustomers) {
        Set<Bank> bankSet = new HashSet<>();
        for (int i = 0; i < amountOfBanks; i++) {
            bankSet.add(generateBank(i, amountOfCustomers));
        }
        return bankSet;
    }

    private Bank generateBank(int nameNumber, int amountOfCustomers) {
        return new Bank("Bank #" + nameNumber,
                "Country #" + nameNumber,
                DEFAULT_CURRENCY_SET,
                customerGenerator.generate(amountOfCustomers));
    }
}