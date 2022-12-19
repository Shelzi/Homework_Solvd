package com.shelzi.solvdlaba.hm2_oop;

import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;

@FunctionalInterface
public interface BankFunction<T extends Bank, R> {
    R apply(T t);
}