package com.manoj.practice.design.patterns.creational;

public class AbstractFactoryDesignPattern {

    public static void main(String[] args) {
        BankAccount account = AbstractBankFactory.createAccount("Retail", "ICICI");

        System.out.println("Account created:- " + account);

    }

}

interface BankAccount {

    public String getAccountNo();

    public String getAccountHolderName();

}

interface InvestmentBankAccount extends BankAccount {

    public abstract AccountType getAccountType();
}

interface RetailBankAccount extends BankAccount {
    public abstract AccountType getAccountType();

}

class GoldmanSachsAccount implements InvestmentBankAccount {

    private String accountNo;
    private String accountHolderName;
    private InvestmentAccountType accountType;

    @Override
    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public InvestmentAccountType getAccountType() {
        return accountType;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(InvestmentAccountType accountType) {
        this.accountType = accountType;
    }

}

class JPMorganAccount implements InvestmentBankAccount {
    private String accountNo;
    private String accountHolderName;
    private InvestmentAccountType accountType;

    @Override
    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public InvestmentAccountType getAccountType() {
        return accountType;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(InvestmentAccountType accountType) {
        this.accountType = accountType;
    }
}

class ICICIAccount implements RetailBankAccount {

    private String accountNo;
    private String accountHolderName;
    private RetailAccountType accountType;

    @Override
    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public RetailAccountType getAccountType() {
        return accountType;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(RetailAccountType accountType) {
        this.accountType = accountType;
    }

}

class SBIAccount implements RetailBankAccount {

    private String accountNo;
    private String accountHolderName;
    private RetailAccountType accountType;

    @Override
    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public RetailAccountType getAccountType() {
        return accountType;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(RetailAccountType accountType) {
        this.accountType = accountType;
    }

}

class AbstractBankFactory {

    public static BankAccount createAccount(String bankType, String bankName) {
        if (bankType.equals("Retail"))
            return new RetailBankFactory().createAccount(bankName);
        else if (bankType.equals("Investment"))
            return new InvestmentBankFactory().createAccount(bankName);
        else
            return null;
    }

}

abstract interface BankFactory {
    public abstract BankAccount createAccount(String bankName);
}

class InvestmentBankFactory implements BankFactory {

    @Override
    public BankAccount createAccount(String bankName) {
        if (bankName.equals("GoldmanSachs"))
            return new GoldmanSachsAccount();
        else if (bankName.equals("JP Morgan"))
            return new JPMorganAccount();
        else
            return null;
    }

}

class RetailBankFactory implements BankFactory {

    @Override
    public BankAccount createAccount(String bankName) {
        if (bankName.equals("ICICI"))
            return new ICICIAccount();
        else if (bankName.equals("SBI"))
            return new SBIAccount();
        else
            return null;
    }

}

interface AccountType {

}

enum RetailAccountType implements AccountType {
    SAVING_ACCOUNT("Savings Account"),
    CURRENT_ACCOUNT("Current Account");

    private String value;

    RetailAccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

enum InvestmentAccountType implements AccountType {
    TRADING_ACCOUNT("TRADING Account"),
    DERIVATIVE_ACCOUNT("Derivative Account");

    private String value;

    InvestmentAccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}