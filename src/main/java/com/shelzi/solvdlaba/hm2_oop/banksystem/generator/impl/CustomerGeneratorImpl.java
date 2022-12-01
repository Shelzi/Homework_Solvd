package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.impl;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.generator.Generator;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Customer;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Person;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomerGeneratorImpl implements Generator<Customer> {
    private static final Lock LOCKER = new ReentrantLock();
    private static volatile Generator<Customer> instance;

    private CustomerGeneratorImpl() {
    }

    public static Generator<Customer> getInstance() {
        if (instance == null) {
            LOCKER.lock();
            if (instance == null) {
                instance = new CustomerGeneratorImpl();
            }
            LOCKER.unlock();
        }
        return instance;
    }

    @Override
    public Set<Customer> generate(int amount) {
        return null;
    }
}
