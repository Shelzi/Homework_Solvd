package main.java.com.shelzi.solvdlaba.hm2_oop;

import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception.ServiceException;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Bank;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.Currency;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.entity.CurrencyId;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.BankService;
import main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.model.service.impl.BankServiceImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Runner {
    private static BankService bankService = BankServiceImpl.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank alfaBank = new Bank("AlfaBank",
                "Belarus",
                Set.of(CurrencyId.EURO, CurrencyId.USD),
                new HashSet<>());

        System.out.println(alfaBank);

        try {
            bankService.addCustomer(alfaBank);
            System.out.println("Enter a owner name of new bank account.");
            bankService.findCustomerByFullName(alfaBank, "Den").getBankAccounts().add(bankService.createBankAccount(alfaBank,
                    bankService.findCustomerByFullName(alfaBank, scanner.nextLine()),
                    CurrencyId.EURO));

            System.out.println(alfaBank);

            bankService.findCustomerByFullName(alfaBank, "Den").getCredits().add(bankService.createCredit(alfaBank,
                    bankService.findCustomerByFullName(alfaBank, "Den"),
                    CurrencyId.USD,
                    new Currency(CurrencyId.USD, 100000),
                    48, //durationDe
                    13.5));     //interest rate (процент)

            System.out.println(alfaBank);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}