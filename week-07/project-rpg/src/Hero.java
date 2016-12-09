/// Created by BB on 2016-12-07.

public class Hero extends Character {

    /// Constructor

    public Hero() {
        super(1, 20 + dice(3), dice(2),  5 + dice(1));
        this.filename = "src/images/hero-down.png";
        this.setImage();
        this.position = new int[] {0,0};
    }

    /// Methods

    public void levelUp() {
        this.level++;
        this.hpMax = this.hpMax+dice(1);
        this.defense = this.defense+dice(1);
        this.attack = this.attack+dice(1);
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

    public String toString(){
        StringBuilder returnString = new StringBuilder();
        returnString.append("Creaturobe");
        returnString.append(super.toString());
        return returnString.toString();
    }
}
