package com.manoj.practice.design.patterns.structural;

public class FacadeDesignPattern {

    public static void main(String[] args) {
        Account acct = FacadeClass.getAccountObj(AccountType.BAL);

        System.out.println(acct.getClass());
    }

}

class FacadeClass {

    public static Account getAccountObj(AccountType type) {
        switch (type) {
        case SVGS:
            return new SavingAccount();
        case CURR:
            return new CurrentAccount();
        case BAL:
            return new BalanceAccount();
        default:
            return null;
        }
    }
}

interface Account {

}

class SavingAccount implements Account {

}

class CurrentAccount implements Account {

}

class BalanceAccount implements Account {

}

enum AccountType {
    SVGS,
    CURR,
    BAL

}