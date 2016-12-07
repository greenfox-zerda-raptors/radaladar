/// Created by BB on 2016-12-07.

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Hero extends Character {

    public Hero() {
        this.filename = "src/images/hero-down.png";
        this.setImage();
        this.position = new int[] {0,0};
        this.hpMax = 20 + dice(3);
        this.hpCurrent = this.hpMax;
        this.isDead = false;
        this.dp = dice(2);
        this.sp = 5 + dice(1);
    }

    public void levelUp() {
        this.hpMax = this.hpMax+dice(1);
        this.dp = this.dp+dice(1);
        this.sp = this.sp+dice(1);
    }

    public void faceDirection(int i) {
        switch (i) {
            case 1:
                this.filename = "src/images/hero-up.png";
                this.setImage();
                break;
            case 2:
                this.filename = "src/images/hero-right.png";
                this.setImage();
                break;
            case 3:
                this.filename = "src/images/hero-down.png";
                this.setImage();
                break;
            case 4:
                this.filename = "src/images/hero-left.png";
                this.setImage();
                break;
        }
    }
}
