//package com.driver;
//
//public class CurrentAccount extends BankAccount{
//    String tradeLicenseId; //consists of Uppercase English characters only
////    private static final double MINIMUM_BALANCE = 5000;
//
//   // private  static final double MINIMUM_BALANCE = 5000;
//    public String getTradeLicenseId() {
//        return tradeLicenseId;
//    }
//
//    public void setTradeLicenseId(String tradeLicenseId) {
//        this.tradeLicenseId = tradeLicenseId;
//    }
//
//    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
//        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
//
////        super(name, balance, MINIMUM_BALANCE);
////        this.tradeLicenseId = tradeLicenseId;
////        if(balance<5000){
////            throw new Exception("Insufficient Balance");
////        }
//
//        super(name, balance, 5000);
//        this.tradeLicenseId = tradeLicenseId;
//        if(balance<5000){
//            throw new Exception("Insufficient Balance");
//
//        }
//    }
//
//    public void validateLicenseId() throws Exception {
//        // A trade license Id is said to be valid if no two consecutive characters are same
//        // If the license Id is valid, do nothing
//        // If the characters of the license Id can be rearranged to create any valid license Id
//        // If it is not possible, throw "Valid License can not be generated" Exception
////        if (!isValidLicenseId()) {
////            rearrangeLicenseId();
////            if (!isValidLicenseId()) {
////                throw new Exception("Valid License cannot be generated");
////            }
////        }
//
//
//        if(!isValidLicenseId()){
//            rearrangeLicenseId();
//            if(!isValidLicenseId()){
//                throw new Exception("Valid License can not be generated");
//            }
//        }
//
//    }
////    private boolean isValidLicenseId() {
////        for (int i = 1; i < tradeLicenseId.length(); i++) {
////            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
////                return false;
////            }
////        }
////        return true;
////    }
//
//    private boolean isValidLicenseId(){
//        for(int i=1;i<tradeLicenseId.length();i++){
//            if(tradeLicenseId.charAt(i)== tradeLicenseId.charAt(i-1)){
//                return false;
//            }
//        }
//        return true;
//    }
//
////    private void rearrangeLicenseId() {
////        char[] licenseIdChars = tradeLicenseId.toCharArray();
////        for (int i = 1; i < tradeLicenseId.length(); i += 2) {
////            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
////                char temp = licenseIdChars[i];
////                licenseIdChars[i] = licenseIdChars[i + 1];
////                licenseIdChars[i + 1] = temp;
////            }
////        }
////        tradeLicenseId = new String(licenseIdChars);
////    }
//
//
//    private  void rearrangeLicenseId(){
//        char[] licenseIdChars = tradeLicenseId.toCharArray();
//        for(int i=1;i<tradeLicenseId.length();i+=2){
//            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i-1)){
//                char temp = licenseIdChars[i];
//                licenseIdChars[i] = licenseIdChars[i+1];
//                licenseIdChars[i+1] = temp;
//
//            }
//        }
//        tradeLicenseId = new String(licenseIdChars);
//    }
//}

package com.driver;

import static java.lang.String.valueOf;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000){
            throw new Exception("Insufficient Balance");
        }

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if(!isNumberValid(tradeLicenseId)){
            String rearrangedId = arrangeString(tradeLicenseId);
            if(rearrangedId == ""){
                throw new Exception("Valid License can not be generated");
            }else{
                this.tradeLicenseId = rearrangedId;
            }
        }
    }


    public boolean isNumberValid(String licenseId){
        for(int i=0; i<licenseId.length()-1; i++){
            if(licenseId.charAt(i) == licenseId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }


    public String arrangeString(String s){
        int n = s.length();

        int[]count = new int[26];
        for(int i=0;i<26;i++){
            count[i] = 0;
        }
        for(char ch: s.toCharArray()){
            count[(int)ch - (int)'A']++;
        }

        char ch_max = getCountChar(count);
        int maxCount = count[(int)ch_max - (int)'A'];

        if(maxCount > (n+1)/2){
            return "";
        }

//        int index = 0;
//        char[]res = new char[n];
//        for(index=0;index<n;index=index+2){
//            if(count[maxCount]>0){
//                res[index] = ch_max;
//                count[maxCount]--;
//            }else{
//                break;
//            }
//        }
//
//        for(int i=0;i<26;i++){
//            char ch = (char)('A' + i);
//            while(count[i] > 0){
//                if(index>n){
//                    index = 1;
//                }
//                res[index] = ch;
//                index = index + 2;
//                count[i]--;
//            }
//        }
//        String ans = valueOf(res);
//        return ans;

        String res = "";
        for (int i = 0; i < n; i++) {
            res += ' ';
        }

        int ind = 0;
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max
                    + res.substring(ind + 1);
            ind = ind + 2;
            maxCount--;
        }
        count[(int) ch_max - (int) 'A'] = 0;
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ind = (ind >= n) ? 1 : ind;
                res = res.substring(0, ind)
                        + (char) ((int) 'A' + i)
                        + res.substring(ind + 1);
                ind += 2;
                count[i]--;
            }
        }
        return res;
    }


    public char getCountChar(int[] count){
        int max = 0;
        char ch = 0;
        for(int i=0;i<26;i++){
            if(count[i]>max){
                max = count[i];
                ch = (char)((int)'A' + i);
            }
        }
        return ch;
    }

}
