package main.java.music;

/**
 * Created by BB on 2016-11-16.
 */
public abstract class StringedInstrument extends Instrument {
    protected int numberOfStrings;
    protected String sound;
    final String formatForPlay ="%s, a %d-stringed instrument that goes %s\n";

    public void play(){
        System.out.printf(formatForPlay, this.name, this.numberOfStrings, this.sound);
    }
}
