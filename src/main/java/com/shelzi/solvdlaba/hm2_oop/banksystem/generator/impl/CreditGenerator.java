package com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl;

import com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Credit;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;
import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CreditGenerator implements Generator<Credit> {
    private static final int DEFAULT_CURRENCY_VALUE_RANDOM_SEED = 100000;
    private static final int DEFAULT_INTEREST_RATE_RANDOM_SEED = 20;
    private static final int DEFAULT_MINIMAL_CREDIT_DURATION = 12;
    private static final int DEFAULT_MAXIMAL_CREDIT_DURATION = 96;

    @Override
    public Set<Credit> generate(int amountOfCredits) {
        Set<Credit> creditSet = new HashSet<>();
        for (int i = 1; i <= amountOfCredits; i++) {
            creditSet.add(generateCredit());
        }
        return creditSet;
    }

    private Credit generateCredit() {
        Random random = new Random();
        return new Credit(new Currency(CurrencyId.randomCurrencyId(),
                random.nextInt(DEFAULT_CURRENCY_VALUE_RANDOM_SEED)),
                random.nextDouble(DEFAULT_INTEREST_RATE_RANDOM_SEED),
                random.nextInt(DEFAULT_MINIMAL_CREDIT_DURATION, DEFAULT_MAXIMAL_CREDIT_DURATION));
    }
}