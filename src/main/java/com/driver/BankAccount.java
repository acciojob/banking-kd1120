package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    String accNo;

    public BankAccount(String name, double balance, double minBalance) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (sum < 0 || sum > digits * 9) {
            throw new Exception("Account Number cannot be generated.");
        }

        Random random = new Random();
        StringBuilder accountNumberBuilder = new StringBuilder();

        for (int i = 0; i < digits - 1; i++) {
            int randomDigit = random.nextInt(Math.min(10, sum + 1));
            accountNumberBuilder.append(randomDigit);
            sum -= randomDigit;
        }

        accountNumberBuilder.append(sum);

        return accountNumberBuilder.toString();


       // return null;
    }

    public void deposit(double amount) {
        //add amount to balance

        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if(this.balance-amount<minBalance){
            throw new ArithmeticException("Insufficient Balance");
        }
        if(amount<=balance){
            this.balance -= amount;
        }

    }

}