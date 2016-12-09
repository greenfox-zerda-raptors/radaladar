/// Created by BB on 2016-12-08.

public class Enemy extends  Character {
    private boolean hasKey;

    public Enemy(int[] position, int level, boolean hasKey) {
        this.filename = "src/images/enemy.png";
        this.setImage();
        this.position = position;
        this.level = level;
        this.hpMax = dice(2 * this.level);
        this.hpCurrent = this.hpMax;
        this.isDead = false;
        this.dp = dice(this.level / 2);
        this.sp = dice(this.level);
        this.hasKey = hasKey;
    }

    public boolean hasKey() {
        return hasKey;
    }
}
