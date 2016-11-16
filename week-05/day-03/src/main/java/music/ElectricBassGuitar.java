package main.java.music;

/**
 * Created by BB on 2016-11-16.
 */
public class ElectricBassGuitar extends StringedInstrument{

    public ElectricBassGuitar() {
        this(4);
    }
    public ElectricBassGuitar(int strings) {
        this.name = "Electric bass guitar";
        this.numberOfStrings = strings;
        this.sound = "duum-duum-duum";
    }
}
