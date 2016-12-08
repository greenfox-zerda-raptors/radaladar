/// Created by BB on 2016-12-08.

public class Enemy extends  Character {

    public Enemy(int[] position) {
        this.filename = "src/images/enemy.png";
        this.setImage();
        this.position = position;
        this.hpMax = 2 * dice(1);
        this.hpCurrent = this.hpMax;
        this.isDead = false;
        this.dp = dice(1) / 2;
        this.sp = dice(1);
    }
}
