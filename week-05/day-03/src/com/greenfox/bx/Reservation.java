package com.greenfox.bx;

/**
 * Created by BB on 2016-11-16.
 */
public class Reservation implements Reservationy {
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

    public Reservation(String dowBooking) {
        this.dowBooking = dowBooking;
        this.codeBooking =randomZeroToZ(8);
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

    public String toString() {
        return "Booking# " + this.codeBooking +" for " + this.dowBooking;
    }
}
