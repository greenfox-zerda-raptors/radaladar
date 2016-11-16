package com.greenfox.bx;

/**
 * Created by BB on 2016-11-16.
 */
public class CreditCardReservation implements CreditCardy, Reservationy{
    private int sumCVV;
    private String nameCardholder;
    private String codeAccount;
    private String dowBooking;
    private String codeBooking;
    private final static String ls = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String randomZeroToZ(int len) {
        String out = "";
        for(int i= 0; i<len; i++) {
            out += ls.charAt((int) (Math.random() * 36));
        }
        return out;
    }

    public CreditCardReservation(String dowBooking, String nameCardholder, String codeAccount) {
        this.dowBooking = dowBooking;
        this.codeBooking =randomZeroToZ(8);
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

    @Override
    public void setDowBooking(String dowBooking) {
        this.dowBooking = dowBooking;
    }

    @Override
    public String getDowBooking() {
        return this.dowBooking;
    }

    @Override
    public void setCodeBooking(String codeBooking) {
        this.codeBooking = randomZeroToZ(8);
    }

    @Override
    public String getCodeBooking() {
        return this.codeBooking;
    }

    @Override
    public boolean PlaceReserved(String dowBooking, String codeBooking) {
        if (dowBooking.equals(this.dowBooking) && codeBooking.equals(this.codeBooking) ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean PlaceCancelled(String dowBooking, String codeBooking) {
        return !(this.PlaceReserved(dowBooking, codeBooking));
    }

    @Override
    public String toString() {
        return "Booking# " + this.codeBooking +" for " + this.dowBooking + " payed by Name = " + this.nameCardholder + " CC#= " + this.codeAccount + " CVV= " + this.sumCVV;
    }
}
