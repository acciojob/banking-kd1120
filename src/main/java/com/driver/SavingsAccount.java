package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getFinalAmt() {
        return finalAmt;
    }

    public void setFinalAmt(double finalAmt) {
        this.finalAmt = finalAmt;
    }

    double finalAmt;
    private static final double MINIMUM_BALANCE = 0;



    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
       // super();
        // minimum balance is 0 by default
        super(name, balance, MINIMUM_BALANCE);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;


    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");

        }
        else if(amount>getBalance()){
            throw new Exception("Insufficient Balance" );
        }
        super.withdraw(amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
      finalAmt = getBalance() + (getBalance()* rate * years);
      return finalAmt;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
   finalAmt = getBalance() * Math.pow((1 + rate/times),(times * years));
   return finalAmt;
    }

}

//A = P * (1 + r/n)^(n*t)
//
//Where:
//A is the future value or the final amount
//P is the principal or the initial amount
//r is the annual interest rate (as a decimal)
//n is the number of times the interest is compounded per year
//t is the number of years
