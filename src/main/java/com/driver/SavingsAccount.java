//package com.driver;
//
//public class SavingsAccount extends BankAccount{
//    double rate;
//    double maxWithdrawalLimit;
//
//    public double getRate() {
//        return rate;
//    }
//
//    public void setRate(double rate) {
//        this.rate = rate;
//    }
//
//    public double getMaxWithdrawalLimit() {
//        return maxWithdrawalLimit;
//    }
//
//    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
//        this.maxWithdrawalLimit = maxWithdrawalLimit;
//    }
////  private static final double MINIMUM_BALANCE = 0;
//
//
// //   private static final double MINIMUM_BALANCE =0;
//
//    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
//       // super();
//        // minimum balance is 0 by default
////        super(name, balance, MINIMUM_BALANCE);
////        this.rate = rate;
////        this.maxWithdrawalLimit = maxWithdrawalLimit;
//
//        super(name, balance, 0);
//        this.rate = rate;
//        this.maxWithdrawalLimit = maxWithdrawalLimit;
//
//    }
//
//    public void withdraw(double amount) throws Exception {
//        // Might throw the following errors:
//        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
//        // 2. "Insufficient Balance" : If the amount exceeds balance
//
//        if(amount <= maxWithdrawalLimit) {
//            super.withdraw(amount);
//        }
//        else {
//            throw new Exception("Maximum Withdraw Limit Exceeded");
//        }
//    }
//
//    public double getSimpleInterest(int years){
//        // Return the final amount considering that bank gives simple interest on current amount
//      return  (getBalance() + (getBalance()* rate * years));
//
//    }
//
//    public double getCompoundInterest(int times, int years){
//        // Return the final amount considering that bank gives compound interest on current amount given times per year
//   double finalAmt = getBalance() * Math.pow((1 + rate/times),(times * years));
//   return finalAmt;
//    }
//
//}
//
////A = P * (1 + r/n)^(n*t)
////
////Where:
////A is the future value or the final amount
////P is the principal or the initial amount
////r is the annual interest rate (as a decimal)
////n is the number of times the interest is compounded per year
////t is the number of years

package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount <= maxWithdrawalLimit) {
            super.withdraw(amount);
        }
        else {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
//        double principle = getBalance();
//        double finalAmount = (principle*rate*years)/100;
//        return finalAmount;
        return getBalance()*(1 + (rate*years)/100);
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
//        double principle = getBalance();
//        double finalAmount = principle * Math.pow((1 + (rate/times)), times*years);
//        return finalAmount;

        double compoundInterest = getBalance() * Math.pow((1 + rate / (100*times)), times * years);
        //  return compoundInterest;
        return compoundInterest;
    }

}