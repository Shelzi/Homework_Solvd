package main.java.com.shelzi.solvdlaba.hm2_oop;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.BankAccount;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Person;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    private static BankService bankService = new ;


    public static void main(String[] args) {
        Bank alfaBank = new Bank("AlfaBank",
                "Belarus",
                Set.of(CurrencyId.EURO, CurrencyId.USD),
                new HashSet<>());

        System.out.println(alfaBank);

        Person person = new Person("Den Dendovich Dendov", new HashSet<>(), new HashSet<>());
        BankAccount bankAccountDen = new BankAccount();
    }
}
