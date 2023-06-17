package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    private static final double MINIMUM_BALANCE = 5000;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, MINIMUM_BALANCE);
        this.tradeLicenseId = tradeLicenseId;
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if (!isValidLicenseId()) {
            rearrangeLicenseId();
            if (!isValidLicenseId()) {
                throw new Exception("Valid License cannot be generated");
            }
        }
    }
    private boolean isValidLicenseId() {
        for (int i = 1; i < tradeLicenseId.length(); i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
    private void rearrangeLicenseId() {
        char[] licenseIdChars = tradeLicenseId.toCharArray();
        for (int i = 1; i < tradeLicenseId.length(); i += 2) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
                char temp = licenseIdChars[i];
                licenseIdChars[i] = licenseIdChars[i + 1];
                licenseIdChars[i + 1] = temp;
            }
        }
        tradeLicenseId = new String(licenseIdChars);
    }

}
