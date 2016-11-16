package main.java.music;

/**
 * Created by BB on 2016-11-16.
 */
public class ElectricBassGuitar extends StringedInstrument{

    public ElectricBassGuitar() {
        this.name = "Electric bass guitar";
        this.numberOfStrings = 4;
        this.sound = "duum-duum-duum";
    }
    public ElectricBassGuitar(int strings) {
        this.name = "Electric bass guitar";
        this.numberOfStrings = strings;
        this.sound = "duum-duum-duum";
    }
}
