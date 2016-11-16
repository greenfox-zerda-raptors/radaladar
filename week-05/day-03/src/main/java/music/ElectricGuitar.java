package main.java.music;

/**
 * Created by BB on 2016-11-16.
 */
public class ElectricGuitar extends StringedInstrument{
    public ElectricGuitar() {
        this.name = "Electric guitar";
        this.numberOfStrings = 6;
        this.sound = "twang";
    }
    public ElectricGuitar(int strings) {
        this.name = "Electric guitar";
        this.numberOfStrings = strings;
        this.sound = "twang";
    }
}
