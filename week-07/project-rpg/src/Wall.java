/// Created by BB on 2016-12-07.

public class Wall extends Tile {

    public Wall(int x, int y) {
        this.filename = "src/images/wall.png";
        this.setImage();
        this.position[0] = x;
        this.position[1] = y;
    }
}
