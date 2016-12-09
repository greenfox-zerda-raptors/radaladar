/// Created by BB on 2016-12-08.

public class Enemy extends  Character {
    private boolean hasKey;

    /// Constructor

    public Enemy(int[] position, int level, boolean hasKey) {
        super(level, dice(2 * level), dice(level / 2),  dice(level));
        this.filename = "src/images/enemy.png";
        this.setImage();
        this.position = position;
        this.hasKey = hasKey;
    }

    /// Methods

    public boolean hasKey() {
        return hasKey;
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Faceflower");
        if (this.hasKey()) {
            returnString.append(" Keyholder");
        }
        returnString.append(super.toString());
        return returnString.toString();
    }
}
