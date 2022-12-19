package com.shelzi.solvdlaba.hm2_oop;

import com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;

@FunctionalInterface
public interface BankComparator<T extends Bank>{
    int compareTo(T t1, T t2);
}
