/// Created by BB on 2016-12-05.

import java.util.Random;

public abstract class Character extends GameObject {
    protected int level;
    protected int hpMax;
    protected int hpCurrent;
    protected boolean isDead;
    protected int defense;
    protected int attack;

    /// Constructor

    public Character(int level, int hpMax, int defense, int attack) {
        this.level = level;
        this.hpMax = hpMax;
        this.hpCurrent = this.hpMax;
        this.isDead = false;
        this.defense = defense;
        this.attack = attack;
    }

    /// Methods

    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("<br>Level: ");
        returnString.append(level);
        returnString.append("<br>");
        returnString.append("HP: ");
        returnString.append(hpMax);
        returnString.append(" / ");
        returnString.append(hpCurrent);
        returnString.append(" | ATK: ");
        returnString.append(attack);
        returnString.append(" | DEF: ");
        returnString.append(defense);
        return returnString.toString();
    }

    static int dice(int numberOfDice) {
        int value = 0;
        Random diceThrow = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            value += (diceThrow.nextInt(6) + 1);
        }
        return value;
    }
}
