/// Created by BB on 2016-12-08.

public class Boss extends Character {

    public Boss(int[] position, int level) {
        this.filename = "src/images/boss.png";
        this.setImage();
        this.position = position;
        this.level = level;
        this.hpMax = dice(2 * (this.level + 1));
        this.hpCurrent = this.hpMax;
        this.isDead = false;
        this.dp = dice((this.level + 1) / 2);
        this.sp = this.level + dice(this.level);
    }
}
