package com.greenfox.bx;

import main.java.music.StringedInstrument;

/**
 * Created by BB on 2016-11-16.
 */

public class CreditCard implements CreditCardy {
    private int sumCVV;
    private String nameCardholder;
    private String codeAccount;


    public CreditCard(String nameCardholder, String codeAccount) {
        this.nameCardholder = nameCardholder;
        this.codeAccount = codeAccount;
        this.sumCVV = cumeSumCVV(codeAccount);
    }

    @Override
    public int getSumCVV() {
        return sumCVV;
    }

    @Override
    public void setSumCVV(int sumCVV) {
        this.sumCVV = sumCVV;
    }

    @Override
    public String getNameCardholder() {
        return nameCardholder;
    }

    @Override
    public void setNameCardholder(String nameCardholder) {
        this.nameCardholder = nameCardholder;
    }

    @Override
    public String getCodeAccount() {
        return codeAccount;
    }

    @Override
    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    @Override
    public String toString() {
        return "Name = " + this.nameCardholder + " CC#= " + this.codeAccount + " CVV= " + this.sumCVV;
    }

    @Override
    public int cumeSumCVV(String codeAccount) {
        int CVV = 0;
        for (int i = 0; i < codeAccount.length(); i++) {
            CVV += Character.getNumericValue(codeAccount.charAt(i));
        }
        return CVV;
    }

    @Override
    public boolean ValidCard(String codeAccount, int sumCVV) {
         return cumeSumCVV(codeAccount) == sumCVV;
    }
}
