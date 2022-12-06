package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BankAccountGenerator implements Generator<BankAccount> {
    private static final int DEFAULT_CURRENCY_VALUE_RANDOM_SEED = 10000;

    @Override
    public Set<BankAccount> generate(int amountOfBanksAccounts) {
        Set<BankAccount> bankAccountSet = new HashSet<>();
        for (int i = 1; i <= amountOfBanksAccounts; i++) {
            bankAccountSet.add(generateBankAccount());
        }
        return bankAccountSet;
    }

    private BankAccount generateBankAccount() {
//        return new BankAccount(new Currency(CurrencyId.randomCurrencyId(),
//                new Random().nextInt(DEFAULT_CURRENCY_VALUE_RANDOM_SEED)));
        return new BankAccount(new Currency(CurrencyId.USD, //Hardcode value
                        new Random().nextInt(DEFAULT_CURRENCY_VALUE_RANDOM_SEED)));
    }
}