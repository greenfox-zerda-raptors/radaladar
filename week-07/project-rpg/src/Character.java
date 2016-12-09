/// Created by BB on 2016-12-05.

import java.util.Random;

public abstract class Character extends GameObject {
    protected int level;
    protected int hpMax;
    protected int hpCurrent;
    protected boolean isDead;
    protected int dp;
    protected int sp;

    /// Static methods
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        if (this instanceof Hero) {
            returnString.append("Hero");
        }
        if (this instanceof Enemy) {
            returnString.append("Faceflower");
            Enemy keyholder = (Enemy) this;
            if (keyholder.hasKey()) {
                returnString.append(" Keyholder");
            }
        }
        if (this instanceof Boss) {
            returnString.append("Overgrowth Warlock");
        }
        returnString.append("<br>Level: ");
        returnString.append(level);
        returnString.append("<br>");
        returnString.append("HP: ");
        returnString.append(hpMax);
        returnString.append(" / ");
        returnString.append(hpCurrent);
        returnString.append(" | ATK: ");
        returnString.append(sp);
        returnString.append(" | DEF: ");
        returnString.append(dp);
        return returnString.toString();
    }
    static int dice(int numberOfDice) {
        int value = 0;
        Random diceThrow = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            value += diceThrow.nextInt(6)+1 ;
        }
        return value;
    }
}
