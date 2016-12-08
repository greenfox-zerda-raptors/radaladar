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

    static int dice(int numberOfDice) {
        int value = 0;
        Random diceThrow = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            value += diceThrow.nextInt(6)+1 ;
        }
        return value;
    }
}
