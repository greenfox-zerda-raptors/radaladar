/// Created by BB on 2016-12-08.

public class Boss extends Character {

    /// Constructor

    public Boss(int[] position, int level) {
        super(level, dice(2 * level + 1), dice(level + 1/ 2),  level + dice(level));
        this.filename = "src/images/boss.png";
        this.setImage();
        this.position = position;
    }

    /// Methods

    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Overgrowth Warlock");
        returnString.append(super.toString());
        return returnString.toString();
    }
}
