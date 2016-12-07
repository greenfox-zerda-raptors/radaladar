/// Created by BB on 2016-12-07.

public class Floor extends Tile {

    public Floor(int x, int y) {
        this.filename = "src/images/floor.png";
        this.setImage();
        this.position[0] = x;
        this.position[1] = y;
    }
}
